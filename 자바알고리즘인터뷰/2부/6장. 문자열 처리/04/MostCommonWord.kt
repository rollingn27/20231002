class MostCommonWord {

    fun mostCommonWord(paragraph: String, banned: Array<String>): String {
        val counts: MutableMap<String, Int> = mutableMapOf();

        val words = paragraph.replace("\\W+".toRegex(), " ").trim().toLowerCase().split(" ")

        for (w in words) {
            if (!banned.contains(w)) {
                counts[w] = counts.getOrDefault(w, 0) + 1
            }
        }

        return counts.maxBy { it.value }!!.key
    }
}