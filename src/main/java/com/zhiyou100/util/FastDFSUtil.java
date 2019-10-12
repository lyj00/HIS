package com.zhiyou100.util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;
import org.springframework.web.multipart.MultipartFile;

import com.zhiyou100.model.ResponseObject;

/**
 * @author Liyajun
 * @date 2019年9月23日
 * @desc 
 * 
 */
public class FastDFSUtil {
	
	public static ResponseObject upload(MultipartFile img) throws IOException, MyException {
		// 获得文件名
		String fileName = img.getOriginalFilename();
		/*
		 * 获得文件后缀名 
		 */
		String[] split = fileName.split("\\.");
		String suffix = split[split.length - 1];
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
		list[0] = new NameValuePair("filename","fileName");
		// 通过客户端执行上传
		String fid = storageClient1.upload_file1(img.getBytes(), suffix,list);
		System.out.println("上传成功" + fid);
		String path = "http://java21:80/"+fid;
		Map<String,String> map = new HashMap<>();
		map.put("path", path);
		map.put("fid", fid);
		return new ResponseObject("200","成功",map);
	}
	
	
	public static byte[] download(String fid) throws IOException, MyException {
		// String fid="group1/M00/00/00/wKiIgF2Ib9aANUL-AAAu4ih_OmI071.jpg";
		ClientGlobal.init("D:\\lyj229\\hhh\\src\\test\\resources\\fastdfs-client.properties");
		// 创建Tracker客户端
		TrackerClient trackerClient = new TrackerClient();
		// 通过Tracker客户端得到Tracker对象
		TrackerServer connection = trackerClient.getConnection();
		// 通过Tracker得到Storage客户端
		StorageClient1 storageClient1 = new StorageClient1(connection, null);
		byte[] bytes = storageClient1.download_file1(fid);
		
		return bytes;
	}
	
	 /**
     * 删除图片
     *
     * @param group
     * @param filePath
     * @return
     */
    public static int deleteFile (String group, String filePath) {
        TrackerServer trackerServer = null;
        StorageServer storageServer = null;
        
        //利用fastdfs客户端，实现文件上传到fastdfs服务器上
        try {
            //代码是模板式的
            //1、加载配置文件
    		ClientGlobal.init("D:\\lyj229\\hhh\\src\\test\\resources\\fastdfs-client.properties");
            
            //2、创建一个tracker的客户端
            TrackerClient trackerClient = new TrackerClient();
            
            //3、通过trackerClient获取一个连接，连接到Tracker，得到一个TrackerServer
            trackerServer = trackerClient.getConnection();
            
            //4、通过trackerClient获取一个存储节点的StorageServer
            storageServer = trackerClient.getStoreStorage(trackerServer);
            
            //5、通过trackerServer和storageServer构造一个Storage客户端
            StorageClient storageClient = new StorageClient(trackerServer, storageServer);
            
            //fastdfs删除文件
            return storageClient.delete_file(group, filePath);
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        } finally {
	        try {
	            //关闭服务，释放资源
	            if (null != storageServer) {
	                storageServer.close();
	            }
	            if (null != trackerServer) {
	                trackerServer.close();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
        }
        return -1;
    }
    /**
     * 删除文件
     * @param group 组名 如：group1
     * @param storagePath 不带组名的路径名称 如：M00/00/00/wKgRsVjtwpSAXGwkAAAweEAzRjw471.jpg
     * @return -1失败,0成功
     */
    public static Integer delete_file(String storagePath){
        int result=-1;
        TrackerServer trackerServer = null;
        StorageServer storageServer = null;
        
        //利用fastdfs客户端，实现文件上传到fastdfs服务器上
        try {
            //代码是模板式的
            //1、加载配置文件
    		ClientGlobal.init("D:\\lyj229\\hhh\\src\\test\\resources\\fastdfs-client.properties");
            
            //2、创建一个tracker的客户端
            TrackerClient trackerClient = new TrackerClient();
            
            //3、通过trackerClient获取一个连接，连接到Tracker，得到一个TrackerServer
            trackerServer = trackerClient.getConnection();
            
            //4、通过trackerClient获取一个存储节点的StorageServer
            storageServer = trackerClient.getStoreStorage(trackerServer);
            
            //5、通过trackerServer和storageServer构造一个Storage客户端
            StorageClient1 storageClient = new StorageClient1(trackerServer, storageServer);
            
            result =storageClient.delete_file1(storagePath);   
       
        } catch (IOException e) {
        e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
        System.out.println(result);
        return  result;
    }
}
