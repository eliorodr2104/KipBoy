package tools

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.cbor.Cbor
import kotlinx.serialization.modules.SerializersModule
import java.io.File

@OptIn(ExperimentalSerializationApi::class)
class FileManager<T>(
    private var pathFolder: String,
    private var nameSerializableFile: String,
    private val serializer: KSerializer<T>
) {
    private val cbor = Cbor { serializersModule = SerializersModule { } }

    fun writeObjectToFile(objectToWrite: T): Boolean {
        return try {
            val bytes = cbor.encodeToByteArray(serializer, objectToWrite)
            File(pathFolder, nameSerializableFile).writeBytes(bytes)
            true

        } catch (e: Exception) {
            println(e.message.toString())
            false
        }
    }

    fun readObjectFromFile(): T? {
        return try {
            val bytes = File(pathFolder, nameSerializableFile).readBytes()
            cbor.decodeFromByteArray(serializer, bytes)

        } catch (e: Exception) {
            println(e.message.toString())
            null
        }
    }
}