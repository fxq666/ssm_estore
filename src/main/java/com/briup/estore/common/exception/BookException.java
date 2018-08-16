package com.briup.estore.common.exception;


/**
 * 此次项目经常报错的地方：
 * 利用ajax异步交互时，如果采用post方式，方法上面一定要加@ResponseBody响应体
 * @ResquestMapping和@ResourceMapping要分清
 * @author ying
 *
 */

public class BookException extends Exception {

	private static final long serialVersionUID = 1L;

	public BookException() {
		super();
	}

	public BookException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BookException(String message, Throwable cause) {
		super(message, cause);
	}

	public BookException(String message) {
		super(message);
	}

	public BookException(Throwable cause) {
		super(cause);
	}
}
