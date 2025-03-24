import com.publicrecord.common.models.Politician
import org.json.JSONObject
import java.time.LocalDate
import java.util.UUID

fun JSONObject.toPolitician(): Politician {
    return Politician(
        id = UUID.fromString(getString("id")),
        firstName = getString("firstName"),
        lastName = getString("lastName"),
        party = getString("party"),
        state = getString("state"),
        office = getString("office"),
        biography = optString("biography"),
        profileImageUrl = optString("profileImageUrl"),
        startDate = LocalDate.parse(getString("startDate")),
        endDate = if (has("endDate") && !isNull("endDate")) LocalDate.parse(getString("endDate")) else null
    )
}
