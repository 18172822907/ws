package com.meicloud.controller;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.meicloud.utils.BasicDataUtil;
import com.meicloud.utils.beans.ResultBean;

/**
 * @autor:JiaLing Li
 */
public abstract class BasicController {

	/**
	 * 该方法执行如下处操作： <br>
	 * 1.封装返回状态和错误信息；<br>
	 * 
	 * @param data
	 *            结果集
	 * @return 处理后的数据
	 */
	protected <T> ResultBean<T> outBound(T data)
			throws IllegalAccessException {

		ResultBean<T> result = new ResultBean<T>();

		result.setData(data);
		result.set__statusCode("1");
		return result;
	}


	/**
	 * 封装异常信息，该方法将设置ResultBean的状态代码为E，并返回异常信息
	 * 
	 * @param e
	 *            异常
	 * @return ResultBean对象
	 */
	protected <T> ResultBean<T> errorHandler(Exception e) {

		ResultBean<T> result = new ResultBean<T>();
		result.setData(null);
		result.set__statusCode("0");
		result.set__errorMessage(e.getMessage());

		return result;
	}

	/**
	 * 封装异常信息，该方法将设置ResultBean的状态代码为E，并返回异常信息
	 * @autor:JiaLing Li
	 * @param error 错误 信息
	 * @return ResultBean对象
	 */
	protected <T> ResultBean<T> errorHandler(String error) {
		ResultBean<T> result = new ResultBean<T>();
		result.setData(null);
		result.set__statusCode("0");
		result.set__errorMessage(error);
		return result;
	}

	/**
	 * 封装 列表信息 转换为特定的json格式：数组嵌数组
	 * @autor:JiaLing Li
	 * @param ob1 对象
	 * @param ob2 对象集合
	 * @param ob3 对象集合总数
	 * @return ResultBean对象
	 */
	protected String getDataInfo(Object ob1,Object ob2,Object ob3){
		List<Object> objList = (List)ob2;
		Object obj =(Object)ob1;
		Long count = (Long)ob3;
		return JSONObject.toJSONString(new BasicDataUtil(obj, objList, count,"X"), SerializerFeature.WriteNullStringAsEmpty);
	}

	/**
	 * 封装 列表信息 转换为特定的json格式：数组嵌对象
	 * @autor:JiaLing Li
	 * @param ob1 对象
	 * @param ob2 对象集合
	 * @param ob3 对象集合总数
	 * @return ResultBean对象
	 */
	protected String getDataObjectInfo(Object ob1,Object ob2,Object ob3){
		List<Object> objList = (List)ob2;
		Object obj =(Object)ob1;
		Long count = (Long)ob3;
		return JSONObject.toJSONString(new BasicDataUtil(obj, objList, count,null), SerializerFeature.WriteNullStringAsEmpty);
	}

}
