package org.lushen.mrh.supports.crypto.none;

import org.lushen.mrh.supports.crypto.CryptoException;
import org.lushen.mrh.supports.crypto.CryptoProvider;

/**
 * 无加解密实现
 * 
 * @author helm
 */
public class NoneCryptoProvider implements CryptoProvider {

	@Override
	public byte[] encrypt(byte[] buffer) throws CryptoException {
		return buffer;
	}

	@Override
	public byte[] decrypt(byte[] buffer) throws CryptoException {
		return buffer;
	}

}
