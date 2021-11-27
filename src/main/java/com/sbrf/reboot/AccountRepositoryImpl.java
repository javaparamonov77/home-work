package com.sbrf.reboot;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class AccountRepositoryImpl implements AccountRepository {

    public AccountRepositoryImpl(String path) {
        this.path = path;
    }

    /**
     * path - передается в конструкторе класса и используется в методе getAllAccountsByClientId()
     * allAccounts - репозиторий аккаунтов
     */
    private final String path;
    private final Set<Account> allAccounts = new HashSet<>();


    public Set<Account> getAllAccounts() {
        return allAccounts;
    }

    public void setAllAccounts(Account account) {
        this.allAccounts.add(account);
    }

    /**
     * @param clientId - ИД клиента (один клиент может иметь несколько аккаунтов(account))
     * @return Set<Account> - полный набор Set из аккаунтов, принадлежащие конкретному клиенту (clientId)
     * @throws IOException
     */

    @Override
    public Set<Account> getAllAccountsByClientId(long clientId) throws IOException {
        String line;
        long value = 0;
        String account;
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
        while ((line = br.readLine()) != null) {
            if (line.contains("number") && value == clientId) {
                account = line.substring(15, line.lastIndexOf("\""));
                allAccounts.add(new Account(account));
            }
            if (line.contains("clientId")) {
                value = Integer.parseInt(line.replaceAll("\\D+", ""));
            }
        }
        br.close();
        return allAccounts;
    }

    /**
     * 5+ задание
     * Требуется иметь возможность корректировать конкретную запись в файле
     * @param clientId - ИД клиента по которому ведется первоначальный поиск
     * @param accountId - Номер счета, который требуется заменить (существующий). Второй компонент поиска в файле.
     * @param newAccountId - Номер счета, на который требуется заменить существующий accountId.
     * @throws IOException
     * Реализация учитывает возможность наличия одинаковых accountId у разных клиентов. Номер счета будет заменен только у нужного клиента.
     * Добавлена проверка на равенство списков. Если списки равны, то файл не перезаписывается (искомые значения для замены не были найдены)
     */

    public void setAccountInFile(long clientId, String accountId, String newAccountId) throws IOException {
        long value = 0;
        String account;
        Path pathF = Paths.get(path);

        List<String> lines = Files.readAllLines(pathF);
        List<String> result = new ArrayList<>();

        for (String s : lines) {
            result.add(s);
            if (s.contains("clientId")) {
                value = Integer.parseInt(s.replaceAll("\\D+", ""));
            }
            if (s.contains("number") && value == clientId) {
                account = s.substring(15, s.lastIndexOf("\""));
                if (account.equals(accountId)) {
                    result.remove(result.size()-1);
                    String replace = s.replace(accountId, newAccountId);
                    result.add(replace);
                }
            }
        }
        if (lines.equals(result)){
            System.out.println("Указанные accountId и clientId не найдены. Файл не перезаписывается");
        } else
            Files.write(pathF, result);
    }
}