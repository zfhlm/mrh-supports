package org.lushen.mrh.supports.file.matcher;

/**
 * psd图片类型
 * 
 * @author helm
 */
public class PicturePsdMatcher extends AbstractFileMatcher {

	public PicturePsdMatcher() {
		super(new int[]{0x38, 0x42, 0x50, 0x53});
	}

}
