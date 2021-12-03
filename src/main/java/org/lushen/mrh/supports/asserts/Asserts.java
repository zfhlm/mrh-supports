package org.lushen.mrh.supports.asserts;

import java.util.Collection;
import java.util.Map;
import java.util.function.Supplier;
import java.util.regex.Pattern;

/**
 * 断言工具
 * 
 * @author hlm
 */
public class Asserts {

	/**
	 * 抛出业务异常
	 * 
	 * @param supplier
	 * @throws E 
	 */
	public static final <E extends Throwable> void error(Supplier<E> supplier) throws E {
		throw supplier.get();
	}

	/**
	 * {@code expression==false} 抛出业务异常
	 * 
	 * @param expression
	 * @param supplier
	 * @throws E 
	 */
	public static final <E extends Throwable> void isTrue(boolean expression, Supplier<E> supplier) throws E {
		if( ! expression ) {
			error(supplier);
		}
	}

	/**
	 * {@code expression==true} 抛出业务异常
	 * 
	 * @param expression
	 * @param supplier
	 * @throws E 
	 */
	public static final <E extends Throwable> void notTrue(boolean expression, Supplier<E> supplier) throws E {
		if(expression) {
			error(supplier);
		}
	}

	/**
	 * {@code arg!=null} 抛出业务异常
	 * 
	 * @param arg
	 * @param supplier
	 * @throws E 
	 */
	public static final <E extends Throwable> void isNull(Object arg, Supplier<E> supplier) throws E {
		if(arg != null) {
			error(supplier);
		}
	}

	/**
	 * {@code arg==null} 抛出业务异常
	 * 
	 * @param arg
	 * @param supplier
	 * @throws E 
	 */
	public static final <E extends Throwable> void notNull(Object arg, Supplier<E> supplier) throws E {
		if(arg == null) {
			error(supplier);
		}
	}

	/**
	 * {@code collection==null || collection.isEmpty()} 抛出业务异常
	 * 
	 * @param collection
	 * @param supplier
	 * @throws E 
	 */
	public static final <E extends Throwable> void notEmpty(Collection<?> collection, Supplier<E> supplier) throws E {
		if(collection == null || collection.isEmpty()) {
			error(supplier);
		}
	}

	/**
	 * {@code collection != null && ! collection.isEmpty()} 抛出业务异常
	 * 
	 * @param collection
	 * @param supplier
	 * @throws E 
	 */
	public static final <E extends Throwable> void isEmpty(Collection<?> collection, Supplier<E> supplier) throws E {
		if(collection != null && ! collection.isEmpty()) {
			error(supplier);
		}
	}

	/**
	 * {@code map==null || map.isEmpty()} 抛出业务异常
	 * 
	 * @param map
	 * @param supplier
	 * @throws E 
	 */
	public static final <E extends Throwable> void notEmpty(Map<?, ?> map, Supplier<E> supplier) throws E {
		if(map == null || map.isEmpty()) {
			error(supplier);
		}
	}

	/**
	 * {@code map != null && ! map.isEmpty()} 抛出业务异常
	 * 
	 * @param map
	 * @param supplier
	 * @throws E 
	 */
	public static final <E extends Throwable> void isEmpty(Map<?, ?> map, Supplier<E> supplier) throws E {
		if(map != null && ! map.isEmpty()) {
			error(supplier);
		}
	}

	/**
	 * {@code array==null || array.length==0} 抛出业务异常
	 * 
	 * @param array
	 * @param supplier
	 * @throws E 
	 */
	public static final <E extends Throwable> void notEmpty(Object[] array, Supplier<E> supplier) throws E {
		if(array==null || array.length==0) {
			error(supplier);
		}
	}

	/**
	 * {@code array != null && array.length != 0} 抛出业务异常
	 * 
	 * @param array
	 * @param supplier
	 * @throws E 
	 */
	public static final <E extends Throwable> void isEmpty(Object[] array, Supplier<E> supplier) throws E {
		if(array != null && array.length != 0) {
			error(supplier);
		}
	}

	/**
	 * {@code org.apache.commons.lang3.StringUtils.isBlank(sequence)} 抛出业务异常
	 * 
	 * @param sequence
	 * @param supplier
	 * @throws E 
	 */
	public static final <E extends Throwable> void notBlank(CharSequence sequence, Supplier<E> supplier) throws E {
		if(org.apache.commons.lang3.StringUtils.isBlank(sequence)) {
			error(supplier);
		}
	}

	/**
	 * {@code org.apache.commons.lang3.StringUtils.isNotBlank(sequence)} 抛出业务异常
	 * 
	 * @param sequence
	 * @param supplier
	 * @throws E 
	 */
	public static final <E extends Throwable> void isBlank(CharSequence sequence, Supplier<E> supplier) throws E {
		if(org.apache.commons.lang3.StringUtils.isNotBlank(sequence)) {
			error(supplier);
		}
	}

	/**
	 * 字符串是否相等，不等抛出业务异常
	 * 
	 * @param seq
	 * @param other
	 * @param supplier
	 * @throws E
	 */
	public static final <E extends Throwable> void equals(CharSequence seq, CharSequence other, Supplier<E> supplier) throws E {
		if( ! org.apache.commons.lang3.StringUtils.equals(seq, other)) {
			error(supplier);
		}
	}

	/**
	 * 字符串是否不等，相等抛出业务异常
	 * 
	 * @param seq
	 * @param other
	 * @param supplier
	 * @throws E
	 */
	public static final <E extends Throwable> void notEquals(CharSequence seq, CharSequence other, Supplier<E> supplier) throws E {
		if(org.apache.commons.lang3.StringUtils.equals(seq, other)) {
			error(supplier);
		}
	}

	/**
	 * {@code sequence==null || sequence.length()==0} 抛出业务异常
	 * 
	 * @param sequence
	 * @param supplier
	 * @throws E 
	 */
	public static final <E extends Throwable> void hasLength(CharSequence sequence, Supplier<E> supplier) throws E {
		if(sequence==null || sequence.length()==0) {
			error(supplier);
		}
	}

	/**
	 * {@code sequence != null && sequence.length() != 0} 抛出业务异常
	 * 
	 * @param sequence
	 * @param supplier
	 * @throws E 
	 */
	public static final <E extends Throwable> void noLength(CharSequence sequence, Supplier<E> supplier) throws E {
		if(sequence != null && sequence.length() != 0) {
			error(supplier);
		}
	}

	/**
	 * 正则表达式匹配失败 抛出业务异常
	 * 
	 * @param sequence
	 * @param regex
	 * @param supplier
	 * @throws E 
	 */
	public static final <E extends Throwable> void isMatched(CharSequence sequence, String regex, Supplier<E> supplier) throws E {
		if( ! Pattern.matches(regex, sequence) ) {
			error(supplier);
		}
	}

	/**
	 * 正则表达式匹配失败 抛出业务异常
	 * 
	 * @param sequence
	 * @param pattern
	 * @param supplier
	 * @throws E 
	 */
	public static final <E extends Throwable> void isMatched(CharSequence sequence, Pattern pattern, Supplier<E> supplier) throws E {
		if( ! pattern.matcher(sequence).matches() ) {
			error(supplier);
		}
	}

	/**
	 * {@code sequence==null || ! sequence.startsWith(prefix)} 抛出业务异常
	 * 
	 * @param sequence
	 * @param prefix
	 * @param supplier
	 * @throws E 
	 */
	public static final <E extends Throwable> void startWith(String sequence, String prefix, Supplier<E> supplier) throws E {
		if(sequence==null || ! sequence.startsWith(prefix)) {
			error(supplier);
		}
	}

	/**
	 * {@code sequence==null || ! sequence.endsWith(subfix)} 抛出业务异常
	 * 
	 * @param sequence
	 * @param subfix
	 * @param supplier
	 * @throws E 
	 */
	public static final <E extends Throwable> void endWith(String sequence, String subfix, Supplier<E> supplier) throws E {
		if(sequence==null || ! sequence.endsWith(subfix)) {
			error(supplier);
		}
	}

	/**
	 * {@code (number > thanNumber) == false } 抛出业务异常
	 * 
	 * @param number
	 * @param thanNumber
	 * @param supplier
	 * @throws E 
	 */
	public static final <E extends Throwable> void largeThan(long number, long thanNumber, Supplier<E> supplier) throws E {
		if( ! (number > thanNumber) ) {
			error(supplier);
		}
	}

	/**
	 * {@code (number >= thanNumber) == false } 抛出业务异常
	 * 
	 * @param number
	 * @param thanNumber
	 * @param supplier
	 * @throws E 
	 */
	public static final <E extends Throwable> void largeThanOrEqual(long number, long thanNumber, Supplier<E> supplier) throws E {
		if( ! (number >= thanNumber) ) {
			error(supplier);
		}
	}

	/**
	 * {@code (number < thanNumber) == false } 抛出业务异常
	 * 
	 * @param number
	 * @param thanNumber
	 * @param supplier
	 * @throws E 
	 */
	public static final <E extends Throwable> void lessThan(long number, long thanNumber, Supplier<E> supplier) throws E {
		if( ! (number < thanNumber) ) {
			error(supplier);
		}
	}

	/**
	 * {@code (number <= thanNumber) == false } 抛出业务异常
	 * 
	 * @param number
	 * @param thanNumber
	 * @param supplier
	 * @throws E 
	 */
	public static final <E extends Throwable> void lessThanOrEqual(long number, long thanNumber, Supplier<E> supplier) throws E {
		if( ! (number <= thanNumber) ) {
			error(supplier);
		}
	}

	/**
	 * {@code number != thanNumber } 抛出业务异常
	 * 
	 * @param number
	 * @param thanNumber
	 * @param supplier
	 * @throws E
	 */
	public static final <E extends Throwable> void equal(long number, long thanNumber, Supplier<E> supplier) throws E {
		if(number != thanNumber) {
			error(supplier);
		}
	}

	/**
	 * {@code number == thanNumber } 抛出业务异常
	 * 
	 * @param number
	 * @param thanNumber
	 * @param supplier
	 * @throws E
	 */
	public static final <E extends Throwable> void notEqual(long number, long thanNumber, Supplier<E> supplier) throws E {
		if(number == thanNumber) {
			error(supplier);
		}
	}

	/**
	 * {@code number != 0 } 抛出业务异常
	 * 
	 * @param number
	 * @param supplier
	 * @throws E
	 */
	public static final <E extends Throwable> void equalZero(long number, Supplier<E> supplier) throws E {
		if(number != 0) {
			error(supplier);
		}
	}

	/**
	 * {@code number == 0 } 抛出业务异常
	 * 
	 * @param number
	 * @param supplier
	 * @throws E
	 */
	public static final <E extends Throwable> void notEqualZero(long number, Supplier<E> supplier) throws E {
		if(number == 0) {
			error(supplier);
		}
	}

}
