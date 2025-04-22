package myWorkSpace;

class Human
{
	int legCount = 2;
	int eyeCount = 2;
}
class Boy extends Human
{
	int eyeCount = 1;
	int legCount = 5;
	int getLegCount()
	{
		return super.legCount;
	}
	int getEyeCount()
	{
		return this.eyeCount;
	}
	
}
class Girl extends Human
{
	int eyeCount = 3;
	int getLegCount()
	{
		return super.legCount;
	}
	int getEyeCount()
	{
		return this.eyeCount;
	}
}


public class SuperThisKeywordUsage {

	public static void main(String[] args) {
		Boy boy = new Boy();
		System.out.println(boy.getEyeCount());
		Girl girl = new Girl();
		System.out.println(girl.getLegCount());
	}

}
