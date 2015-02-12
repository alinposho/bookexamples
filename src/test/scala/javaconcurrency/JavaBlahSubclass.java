package javaconcurrency;

import java.util.List;

public class JavaBlahSubclass extends JavaBlah {

	public JavaBlahSubclass(int field) {
		super(field);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getList() {
		return super.getList();
	}

	

}
