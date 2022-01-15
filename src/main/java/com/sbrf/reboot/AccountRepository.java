package com.sbrf.reboot;

import java.io.IOException;
import java.util.Set;

public interface AccountRepository {
    Set<Account> getAllAccountsByClientId(long clientId) throws IOException;
import java.util.Set;

public interface AccountRepository {
    Set<Account> getAllAccountsByClientId (long clientId);
}
