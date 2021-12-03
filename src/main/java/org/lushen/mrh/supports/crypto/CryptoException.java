package org.lushen.mrh.supports.crypto;

/**
 * 加解密异常
 * 
 * @author helm
 */
public class CryptoException extends Exception {

	private static final long serialVersionUID = 8147551928392286077L;

	public CryptoException(String message, Throwable cause) {
		super(message, cause);
	}

	public CryptoException(String message) {
		super(message);
	}

	public CryptoException(Throwable cause) {
		super(cause);
	}

}
