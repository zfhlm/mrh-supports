package org.lushen.mrh.supports.file;

import java.io.File;
import java.util.Arrays;
import java.util.function.Supplier;

import org.lushen.mrh.supports.file.matcher.CompressRarMatcher;
import org.lushen.mrh.supports.file.matcher.CompressZipMatcher;
import org.lushen.mrh.supports.file.matcher.PictureBmpMatcher;
import org.lushen.mrh.supports.file.matcher.PictureGifMatcher;
import org.lushen.mrh.supports.file.matcher.PictureJpgMatcher;
import org.lushen.mrh.supports.file.matcher.PicturePngMatcher;
import org.lushen.mrh.supports.file.matcher.PicturePsdMatcher;
import org.lushen.mrh.supports.file.matcher.PictureTiffMatcher;
import org.lushen.mrh.supports.file.matcher.UnknownFileMatcher;

/**
 * 文件类型
 * 
 * @author helm
 */
public enum FileType implements FileTypeMatcher {

	PNG(PicturePngMatcher::new),

	JPG(PictureJpgMatcher::new),

	BMP(PictureBmpMatcher::new),

	GIF(PictureGifMatcher::new),

	TIFF(PictureTiffMatcher::new),

	PSD(PicturePsdMatcher::new),

	ZIP(CompressZipMatcher::new),

	RAR(CompressRarMatcher::new),

	UNKNOWN(UnknownFileMatcher::new);

	private FileTypeMatcher matcher;

	private FileType(Supplier<FileTypeMatcher> factory) {
		this(factory.get());
	}

	private FileType(FileTypeMatcher matcher) {
		this.matcher = matcher;
	}

	@Override
	public boolean matches(File file) {
		return this.matcher.matches(file);
	}

	@Override
	public boolean matches(byte[] buffer) {
		return this.matcher.matches(buffer);
	}

	/**
	 * 获取文件类型，无可知类型返回UNKNOWN
	 * 
	 * @param file
	 * @return
	 */
	public static final FileType of(File file) {
		return of(file, FileType.values());
	}

	/**
	 * 获取文件类型，无可知类型返回UNKNOWN
	 * 
	 * @param buffer
	 * @return
	 */
	public static final FileType of(byte[] buffer) {
		return of(buffer, FileType.values());
	}

	/**
	 * 获取文件类型，无指定类型返回UNKNOWN
	 * 
	 * @param file
	 * @param targetTypes
	 * @return
	 */
	public static final FileType of(File file, FileType... targetTypes) {
		return Arrays.stream(targetTypes).filter(ft -> ft.matches(file)).findFirst().orElse(UNKNOWN);
	}

	/**
	 * 获取文件类型，无指定类型返回UNKNOWN
	 * 
	 * @param buffer
	 * @param targetTypes
	 * @return
	 */
	public static final FileType of(byte[] buffer, FileType... targetTypes) {
		return Arrays.stream(targetTypes).filter(ft -> ft.matches(buffer)).findFirst().orElse(UNKNOWN);
	}

}
