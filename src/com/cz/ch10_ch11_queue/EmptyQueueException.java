package com.cz.ch10_ch11_queue;

import java.util.Queue;

public class EmptyQueueException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public EmptyQueueException() {
		this("EmptyQueueException");
	}
	public EmptyQueueException(String msg) {
		super(msg);
	}
}
