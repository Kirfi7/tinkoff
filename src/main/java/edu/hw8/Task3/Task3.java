package edu.hw8.Task3;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task3 {
    private final static int NUM_SYSTEM = 16;
    private final ConcurrentMap<String, String> result = new ConcurrentHashMap<>();
    public List<PasswordWithLogin> userDB;

    public Map<String, String> getPasswords(
        List<String> data,
        int minLen,
        int maxLen,
        char[] alphabet
    ) {
        initUserDB(data);

        for (var i = minLen; i <= maxLen; i++) {
            generate(0, i, new StringBuilder(), alphabet);
            if (result.keySet().size() == data.size()) {
                return result;
            }
        }

        return result;
    }

    public Map<String, String> getPasswordsMultiThreads(
        List<String> data,
        int minLen,
        int maxLen,
        char[] alphabet
    ) {
        initUserDB(data);

        try (
            ExecutorService exec = Executors.newFixedThreadPool(maxLen - minLen + 1)
        ) {
            for (int i = maxLen; i >= minLen; i--) {
                int finalI = i;
                exec.execute(
                    () -> generate(0, finalI, new StringBuilder(), alphabet)
                );
            }
        }

        return result;
    }

    private void initUserDB(List<String> data) {
        userDB = new ArrayList<>(data.size());
        for (String user : data) {
            String[] spl = user.split("\\s+");
            userDB.add(new PasswordWithLogin(spl[0], spl[1]));
        }
    }

    @SuppressWarnings("MagicNumber")
    private void generate(
        int curLen,
        int maxLen,
        StringBuilder sb,
        char[] alphabet
    ) {
        if (curLen == maxLen) {
            MessageDigest md;
            try {
                md = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }

            String password = sb.toString();
            byte[] bytes = md.digest(password.getBytes());

            StringBuilder passwordHash = new StringBuilder();
            for (byte aByte : bytes) {
                passwordHash.append(Integer.toString((aByte & 0xff) + 0x100, NUM_SYSTEM).substring(1));
            }

            for (PasswordWithLogin user : userDB) {
                if (passwordHash.toString().equals(user.password())) {
                    result.put(user.login(), password);
                    break;
                }
            }

            return;
        }

        for (char symb : alphabet) {
            sb.append(symb);
            generate(curLen + 1, maxLen, sb, alphabet);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
