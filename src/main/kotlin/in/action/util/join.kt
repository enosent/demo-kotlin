@file:JvmName("StringFunctions") // class 이름을 지정하는 annotation
package `in`.action.util


/*

@JvmOverloads 사용을 하면

public static final String joinToString(@NotNull Collection collection, @NotNull String separator, @NotNull String prefix, @NotNull String postfix) {
public static final String joinToString(@NotNull Collection collection, @NotNull String separator, @NotNull String prefix) {
public static final String joinToString(@NotNull Collection collection, @NotNull String separator) {
public static final String joinToString(@NotNull Collection collection) {


kotlin compiler 자동으로 맨 마지막 파라미터로부터 파라미터를 하나씩 생략한 오버로딩한 자바 메소드를 추가
 */

@JvmOverloads
fun <T> joinToString(
    collection: Collection<T>,
    separator: String = ", ",
    prefix: String = "",
    postfix: String = "" // default 값 지정
): String {

    val result = StringBuilder(prefix)

    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}

/*
// Decompile 결과

public final class JoinKt {

    public static final String joinToString(@NotNull Collection ... {
        ...
    }
}

 */