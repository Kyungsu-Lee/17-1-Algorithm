package sort.time;

public class TimeManager
{
	private double startTime;
	private double endTime;

	public TimeManager()
	{
		
	}

	public void start()
	{
		this.startTime = System.nanoTime();
	}

	public void end()
	{
		this.endTime = System.nanoTime();
	}

	public double getRunTime()
	{
		return Math.abs(this.startTime - this.endTime);
	}

	@Override
	public String toString()
	{
		return this.getRunTime() + "ns";
	}
}
