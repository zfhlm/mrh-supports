package org.lushen.mrh.supports.file.matcher;

/**
 * tif图片类型
 * 
 * @author helm
 */
public class PictureTiffMatcher extends AbstractFileMatcher {

	public PictureTiffMatcher() {
		super(new int[]{0x49, 0x49, 0x2A, 0x00});
	}

}
