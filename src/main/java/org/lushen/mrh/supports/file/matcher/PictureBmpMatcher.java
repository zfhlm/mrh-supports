package org.lushen.mrh.supports.file.matcher;

/**
 * BMP图片类型
 * 
 * @author helm
 */
public class PictureBmpMatcher extends AbstractFileMatcher {

	public PictureBmpMatcher() {
		super(new int[]{0x42, 0x4D});
	}

}
