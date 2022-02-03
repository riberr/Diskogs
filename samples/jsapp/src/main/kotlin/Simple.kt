import kotlinx.browser.document
import me.riberr.diskogs.Diskogs
import me.riberr.diskogs.endpoints.database
import me.riberr.diskogs.endpoints.database.getArtist

suspend fun main() {
    val diskogs = Diskogs.create("FooBarApp/3.0")

    diskogs.database.getArtist(666)
        .onSuccess {
            console.log(it.toString())
            document.write(it.toString())
        }
        .onFailure {
            console.log(it.toString())
            document.write(it.toString())
        }
}