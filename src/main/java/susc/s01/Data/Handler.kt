package susc.s01.Data

interface Handler<K, E> {
    fun putData(e: E)
    fun getData(k: K): E
    @Throws(Exception::class)
    fun replaceData(e: E): Boolean
    @Throws(Exception::class)
    fun removeData(k: K): Boolean
    val allUserTable: ArrayList<E>
    fun updateAllUserData(newUserData: ArrayList<E>?)
}

