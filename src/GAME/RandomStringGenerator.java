package GAME;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomStringGenerator {
    // 包含所有元音字母的字符串
    private static final String vowels = "aeiou";
    // 包含所有辅音字母的字符串
    private static final String consonants = "bcdfghjklmnpqrstvwxyz";
    // 随机数生成器
    private static final Random random = new Random();
    // 已生成的字符串集合
    private static final Set<String> generatedStrings = new HashSet<>();

    /**
     * 生成一个随机字符串
     *
     * @return 生成的随机字符串
     */
    public static String generateRandomString() {
        StringBuilder sb = new StringBuilder();
        // 1.生成随机字符串，直到生成的字符串不在已生成字符串集合中
        while (true) {
            if (generatedStrings.contains(sb.toString())) {
                // 如果已经生成过这个字符串，则重新生成
                sb = new StringBuilder();
                continue;
            }
            break;
        }
        // 2.生成11位随机字符串
        for (int i = 0; i < 11; i++) {
            // 生成一个随机索引
            int randomIndex = random.nextInt(vowels.length() + consonants.length());
            // 随机字符
            char randomChar;
            if (randomIndex < vowels.length()) {
                // 随机选择一个元音字母
                randomChar = vowels.charAt(randomIndex);
            } else {
                // 随机选择一个辅音字母
                randomChar = consonants.charAt(randomIndex - vowels.length());
            }
            // 将随机字符添加到StringBuilder中
            sb.append(randomChar);
        }
        // 将生成的字符串添加到已生成字符串集合中
        generatedStrings.add(sb.toString());
        // 返回生成的随机字符串
        return sb.toString();
    }

    public static void main(String[] args) {
        // 生成一个随机字符串
        String randomString = generateRandomString();
        // 输出随机字符串
        System.out.println(randomString);
    }
}