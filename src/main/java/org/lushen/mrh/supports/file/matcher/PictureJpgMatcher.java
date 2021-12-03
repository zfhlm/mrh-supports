package org.lushen.mrh.supports.file.matcher;

/**
 * JPG图片类型
 * 
 * @author helm
 */
public class PictureJpgMatcher extends AbstractFileMatcher {

	public PictureJpgMatcher() {
		super(new int[]{0xFF, 0xD8, 0xFF});
	}

}
