package jvm;

import java.util.EnumSet;

import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.ElementScanner8;
import javax.tools.Diagnostic.Kind;

public class NameChecker {
	private final Messager messager;

	NameCheckScanner nameCheckScanner = new NameCheckScanner();

	public NameChecker(ProcessingEnvironment processingEnv) {
		// TODO Auto-generated constructor stub
		this.messager = processingEnv.getMessager();
	}

	public void checkNames(Element element) {
		// TODO Auto-generated method stub
		nameCheckScanner.scan(element);
	}

	private class NameCheckScanner extends ElementScanner8<Void, Void> {
		@Override
		public Void visitType(TypeElement e, Void p) {
			scan(e.getTypeParameters(), p);
			checkCamelCase(e, true);
			super.visitType(e, p);
			return null;
		}

		@Override
		public Void visitExecutable(ExecutableElement e, Void p) {
			if (e.getKind() == ElementKind.METHOD) {
				Name name = e.getSimpleName();
				if (name.contentEquals(e.getEnclosingElement().getSimpleName())) {
					messager.printMessage(Kind.WARNING, "一个普通方法" + name
							+ "不应当与类名重复，避免与构造函数产生混淆", e);
				}
				checkCamelCase(e, false);
			}
			super.visitExecutable(e, p);
			return null;
		}

		@Override
		public Void visitVariable(VariableElement e, Void p) {
			if (e.getKind() == ElementKind.ENUM_CONSTANT
					|| e.getConstantValue() != null || heuristicallyConstant(e)) {
				checkAllCaps(e);
			} else {
				checkCamelCase(e, false);
			}
			return null;
		}

		private boolean heuristicallyConstant(VariableElement e) {
			// TODO Auto-generated method stub
			if (e.getEnclosingElement().getKind() == ElementKind.INTERFACE) {
				return true;
			} else if (e.getKind() == ElementKind.FIELD
					&& e.getModifiers().containsAll(
							EnumSet.of(Modifier.PUBLIC, Modifier.STATIC,
									Modifier.FINAL))) {
				return true;
			} else {
				return false;
			}
		}

		private void checkCamelCase(Element e, boolean initialCaps) {
			// TODO Auto-generated method stub
			String name = e.getSimpleName().toString();
			boolean previousUpper = false;
			boolean conventional = true;
			int firstCodePoint = name.codePointAt(0);

			if (Character.isUpperCase(firstCodePoint)) {
				previousUpper = true;
				if (!initialCaps) {
					messager.printMessage(Kind.WARNING, "名称" + name
							+ "应当以小写字母开头", e);
					return;
				}
			} else if (Character.isLowerCase(firstCodePoint)) {
				if (initialCaps) {
					messager.printMessage(Kind.WARNING, "名称" + name
							+ "应当以大写字母开头", e);
					return;
				}
			} else {
				conventional = false;
			}

			if (conventional) {
				int cp = firstCodePoint;
				for (int i = Character.charCount(firstCodePoint); i < name
						.length(); i += Character.charCount(cp)) {
					cp = name.codePointAt(i);
					if (Character.isUpperCase(cp)) {
						if (previousUpper) {
							conventional = false;
							break;
						}
						previousUpper = true;
					} else {
						previousUpper = false;
					}
				}
			}

			if (!conventional) {
				messager.printMessage(Kind.WARNING, "名称" + name
						+ "应当符合驼式命名法(Camel Case Names)", e);
			}
		}

		private void checkAllCaps(VariableElement e) {
			// TODO Auto-generated method stub
			String name = e.getSimpleName().toString();
			boolean conventional = true;
			int firstCodePoint = name.codePointAt(0);

			if (!Character.isUpperCase(firstCodePoint)) {
				conventional = false;
			} else {
				boolean previousUnderscore = false;
				int cp = firstCodePoint;

				for (int i = Character.charCount(cp); i < name.length(); i += Character
						.charCount(cp)) {
					cp = name.codePointAt(i);
					if (cp == (int) '_') {
						if (previousUnderscore) {
							conventional = false;
							break;
						}
						previousUnderscore = true;
					} else {
						previousUnderscore = false;
						if (!Character.isUpperCase(cp)
								&& !Character.isDigit(cp)) {
							conventional = false;
							break;
						}
					}
				}
			}

			if (!conventional) {
				messager.printMessage(Kind.WARNING, "常量" + name
						+ "应当全部以大写或下划线命名，并且以字母开头", e);
			}
		}
	}

}
