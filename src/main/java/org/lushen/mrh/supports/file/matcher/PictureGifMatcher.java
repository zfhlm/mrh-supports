package org.lushen.mrh.supports.file.matcher;

/**
 * git图片类型
 * 
 * @author helm
 */
public class PictureGifMatcher extends AbstractFileMatcher {

	public PictureGifMatcher() {
		super(new int[]{0x47, 0x49, 0x46, 0x38});
	}

}
