package susc.s01.Data.Log;

import susc.s01.Data.Log.JoinLog.PlayerLog;

import java.util.ArrayList;

public interface Handler<K,E> {
    void putData(E e);
    E getData(K k);
    Boolean replaceData(E e) throws Exception;
    Boolean removeData(K k) throws Exception;
    ArrayList<E> getAllUserTable();
    void updateAllUserData(ArrayList<E> newUserData);
}

