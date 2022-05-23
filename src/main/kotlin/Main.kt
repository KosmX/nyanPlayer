
import java.io.ByteArrayOutputStream
import java.io.DataInputStream
import java.nio.Buffer
import java.nio.ByteBuffer
import java.util.*
import javax.sound.sampled.AudioSystem
import javax.sound.sampled.Clip


fun main() {


    val stream = DataInputStream(object{}.javaClass.getResourceAsStream("a") ?: throw NullPointerException("UwU"))
    val out = ByteArrayOutputStream()

    for (i in 0 until 0x74) {
        out.write( stream.read().let { ((it+42)%0x100) })
    }


    val i = stream.readBytes()
    out.write(i)

    val bytes = out.toByteArray()



    val byteStream = bytes.inputStream()


    val inputStream = AudioSystem.getAudioInputStream(byteStream)
    val clip = AudioSystem.getClip()
    clip.open(inputStream)
    clip.start()
    clip.loop(Clip.LOOP_CONTINUOUSLY)

    while (true) {
        Thread.sleep(Long.MAX_VALUE)
    }
}
