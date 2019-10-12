package com.zhiyou100;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;
import com.zhiyou100.util.FastDFSUtil;

/**
 * @author Liyajun
 * @date 2019年9月23日
 * @desc 
 * 上传:
 * 下载:
 * 删除:
 */
public class TestFastDFS {
	/*
	 * 1. 依赖 /jar
	 * 2. FastDFS配置文件:
	 * 3. javaapi
	 * 		加载配置文件
	 * 		创建Tracker客户端
	 * 		通过Tracker客户端得到Tracker对象
	 * 		通过Tracker得到Storage客户端
	 * 		创建文件属性存储对象
	 * 		通过客户端执行上传
	 */
	@Test
	public void upload() throws IOException, MyException {
		// 加载配置文件 
		// 绝对路径
		ClientGlobal.init("D:\\lyj229\\hhh\\src\\test\\resources\\fastdfs-client.properties");
		// 创建Tracker客户端
		TrackerClient trackerClient = new TrackerClient();
		// 通过Tracker客户端得到Tracker对象
		TrackerServer connection = trackerClient.getConnection();
		// 通过Tracker得到Storage客户端
		StorageClient1 storageClient1 = new StorageClient1(connection, null);
		// 创建文件属性存储对象
		NameValuePair[] list  = new NameValuePair[1];
		list[0] = new NameValuePair("filename","1.jpg");
		// 通过客户端执行上传
		String path = storageClient1.upload_file1("D:\\我的文档\\My Pictures\\1.jpg", "jpg",list);
		System.out.println("path : "+ path);
		System.out.println("结束");
	}
	@Test
	public void download() throws IOException, MyException {
		String fid="group1/M00/00/00/wKidgF2IuRWAIhA0AAAyH04a2mU055.jpg";
		
		ClientGlobal.init("D:\\lyj229\\hhh\\src\\test\\resources\\fastdfs-client.properties");
		// 创建Tracker客户端
		TrackerClient trackerClient = new TrackerClient();
		// 通过Tracker客户端得到Tracker对象
		TrackerServer connection = trackerClient.getConnection();
		// 通过Tracker得到Storage客户端
		StorageClient1 storageClient1 = new StorageClient1(connection, null);
		byte[] download_file1 = storageClient1.download_file1(fid);
		OutputStream out = new FileOutputStream("C://Users//Administrator//Desktop//520.jpg");
		out.write(download_file1);
		out.close();
		System.out.println("下载成功");
	}
	
	
	
	@Test
	public void ajaxdeleteFastDFS() {
		 int num = FastDFSUtil.delete_file("group1/M00/00/00/wKiIgF2IjpiAC2btAAIqyZCjyAo413.jpg");
		 System.out.println("删除结果：" +(num == -1?"删除失败":"删除成功"));
	}


	
	
	
	
//	@Test
//	public void ajaxdownloadFastDFS() throws IOException, MyException {
//		String path = FastDFSUtil.download("group1/M00/00/00/wKidgF2IsRKAaaZ2AAAb_61lPnY441.jpg",new FileOutputStream("C://Users//Administrator//Desktop//555.jpg"));
//		
//		System.out.println(path);
//		// return path;
//	}	
	
	
	
	
	
	
	
	
	
	
	
	

}
