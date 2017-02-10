package org.om.aec.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeviceDataProcessor
{
	private static String[] createDummyData(int lenght)
	{
		long serialNoPrefix = 11;
		String deviceNamePrefix = "Device";
		String[] outputs = new String[lenght];
		for(int i = 0; i < lenght; i++)
		{
			outputs[i] = serialNoPrefix + i + deviceNamePrefix + i;
		}
		
		return outputs;
	}
	public static void main(String[] args)
	{
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		ExecutorCompletionService<DeviceInfo> completionService = 
				new ExecutorCompletionService<DeviceInfo>(executorService);
		
		String[] dummyData = createDummyData(89);
		
		for (String deviceData : dummyData) 
		{
			completionService.submit(new DeviceInfoExtractorTask(deviceData));
		}
		
		List<DeviceInfo> deviceInfos = new ArrayList<DeviceInfo>();
		
		for(int i = 0; i < dummyData.length; i++)
		{
			try {
				deviceInfos.add( completionService.take().get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		
		for (DeviceInfo deviceInfo : deviceInfos) {
			System.out.println(deviceInfo);
		}
		
	}
}

class DeviceInfoExtractorTask implements Callable<DeviceInfo>
{
	private final String deviceData;

	public DeviceInfoExtractorTask(String deviceData)
	{
		this.deviceData = deviceData;
	}
	
	public DeviceInfo call() throws Exception
	{
		long serialNo = Long.parseLong(deviceData.substring(0, 2));
		String deviceName = deviceData.substring(2, deviceData.length());
		return new DeviceInfo(serialNo, deviceName);
	}
	
}

final class DeviceInfo
{
	private long serialNo;
	private String name;

	public DeviceInfo(long serialNo, String name)
	{
		this.serialNo = serialNo;
		this.name = name;
	}

	public long getSerialNo() {
		return serialNo;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Device [serialNo=" + serialNo + ", name=" + name + "]";
	}
	
	
}
