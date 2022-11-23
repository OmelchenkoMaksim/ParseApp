package com.example.parsingapp.data.repository

import com.example.parsingapp.data.models.CloudModel
import com.example.parsingapp.data.models.ParseModel
import com.example.parsingapp.data.models.UiModel
import com.example.parsingapp.domain.repository.BaseRepository
import com.example.parsingapp.domain.repository.CloudDataSource

class RepositoryImpl(
    private val cloudDataSource: CloudDataSource<CloudModel>,
) : BaseRepository<UiModel> {

    override suspend fun fetch(): UiModel {
        val result = mutableListOf<String>()
        cloudDataSource.fetch().numbers.forEach { num ->
            val binary = if (num < MIN_BYTE_VALUE || num > MAX_BYTE_VALUE) {
                OUT_OF_RANGE
            } else num.toString(PARSE_THIS_BINARY)
            result.add(binary)
        }
        return UiModel(convert(result))
    }

    private fun convert(list: List<String>): MutableList<ParseModel> {
        val result = mutableListOf<ParseModel>()
        list.forEach { number ->
            result.add(when (number.length) {
                1, 2 -> {
                    val section = Integer.parseInt(number, PARSE_THIS_BINARY) + INCREASE_BY_ONE_FOR_MATCH_ITEM
                    ParseModel(item = 1, section = section)
                }
                3 -> {
                    val section =
                        Integer.parseInt(number.subSequence(1, number.length).toString(), PARSE_THIS_BINARY) + INCREASE_BY_ONE_FOR_MATCH_ITEM
                    ParseModel(item = 1, section = section)
                }
                4, 5, 6, 7 -> {
                    val pair = splitter(number = number, dropFirst = false)
                    ParseModel(item = pair.first, section = pair.second)
                }
                // a significant bit is a concept that requires further clarification,
                // because it can have different interpretations. Since the conversion examples
                // do not make it possible to establish the concept of a significant bit exactly,
                // only the first bit of eight numbers will be recognized as significant.
                8 -> {
                    val pair = splitter(number = number, dropFirst = true)
                    ParseModel(mark = true, item = pair.first, section = pair.second)
                }
                else -> ParseModel(out = true, section = OUT_SECTION)
            })
        }
        return result
    }

    private fun splitter(number: String, dropFirst: Boolean = false): Pair<Int, Int> {
        var section = number.takeLast(SECTION)
        // crop first number if length = 8
        val splitFrom = if (dropFirst) 1 else 0
        section = (Integer.parseInt(section, PARSE_THIS_BINARY) + INCREASE_BY_ONE_FOR_MATCH_ITEM).toString()
        val value =
            (Integer.parseInt(number.subSequence(splitFrom, number.length - DROP_SECTION).toString(), PARSE_THIS_BINARY)
                    + INCREASE_BY_ONE_FOR_MATCH_ITEM).toString()
        return Pair(Integer.parseInt(value), Integer.parseInt(section))
    }

    private companion object {
        const val MIN_BYTE_VALUE = 0
        const val MAX_BYTE_VALUE = 255
        const val OUT_OF_RANGE = "OUT OF RANGE"
        const val PARSE_THIS_BINARY = 2
        const val INCREASE_BY_ONE_FOR_MATCH_ITEM = 1
        const val DROP_SECTION = 2
        const val OUT_SECTION = 9
        const val SECTION = 2
    }

}

