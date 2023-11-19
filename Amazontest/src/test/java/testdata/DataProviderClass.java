package testdata;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	@DataProvider(name = "data-provider")
	public Object[] dataProviderMethod()
	{
		Object result[][]=ExcelSheet.readdata("Login");
		return result;
	}
	@DataProvider(name="data-provider-createaccount")
		public Object[] dataProviderMethod2()
		{
			Object result[][]=ExcelSheet.readdata("Create Account");
			return result;
		}
	@DataProvider(name="data-provider-youraddress")
	public Object[] dataProviderMethod3()
	{
		Object result[][]=ExcelSheet.readdata("Your Address");
		return result;
	}
	@DataProvider(name="data-provider-keywords")
	public Object[] dataProviderMethod4()
	{
		Object result[][]=ExcelSheet.readdata("keywords");
		return result;
	}

}
