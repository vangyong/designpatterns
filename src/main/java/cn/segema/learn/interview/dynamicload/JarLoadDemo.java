package cn.segema.learn.interview.dynamicload;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JarLoadDemo {

	private static Logger logger = LoggerFactory.getLogger(JarLoadDemo.class);

	public static void main(String[] args) throws Exception {

		// 系统类库路径
		File libPath = new File("/data/datas/dynamicload/jars");

		// 获取所有的.jar和.zip文件
		File[] jarFiles = libPath.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.endsWith(".jar") || name.endsWith(".zip");
			}
		});

		if (jarFiles != null) {
			// 从URLClassLoader类中获取类所在文件夹的方法
			// 对于jar文件，可以理解为一个存放class文件的文件夹
			Method method = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
			boolean accessible = method.isAccessible(); // 获取方法的访问权限
			try {
				if (accessible == false) {
					method.setAccessible(true); // 设置方法的访问权限
				}
				// 获取系统类加载器
				URLClassLoader classLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
				for (File file : jarFiles) {
					URL url = file.toURI().toURL();
					try {
						method.invoke(classLoader, url);
						logger.debug("读取jar文件[name={}]", file.getName());
					} catch (Exception e) {
						logger.error("读取jar文件[name={}]失败", file.getName());
					}
				}
			} finally {
				method.setAccessible(accessible);
			}
		}

	}

}
