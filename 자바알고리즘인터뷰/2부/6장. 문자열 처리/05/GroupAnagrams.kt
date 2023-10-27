class GroupAnagrams {

    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val results: MutableMap<String, MutableList<String>> = mutableMapOf()

        for (s in strs) {
            val key = s.toCharArray().sorted().joinToString("");
            results.getOrPut(key) { mutableListOf() }
            results[key]!!.add(s)
        }

        return ArrayList<List<String>>(results.values)
    }
}