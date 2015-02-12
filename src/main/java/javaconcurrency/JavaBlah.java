package javaconcurrency;

import java.util.ArrayList;
import java.util.List;

public class JavaBlah {
	
	private int field;
	private InnerBlah inner = new InnerBlah();

	public JavaBlah(int field) {
		this.field = field;
	}

	public int getField() {
		return field;
	}

	public InnerBlah getInner() {
		return inner;
	}
	
	@SuppressWarnings("rawtypes")
	public List getList() {
		return new ArrayList();
	}

	public final class InnerBlah {
		public JavaBlah getOuter() {
			return JavaBlah.this;
		}
	}

}


