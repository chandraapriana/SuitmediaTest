package com.chandra.suitmediatest.utils

import com.chandra.suitmediatest.R
import com.chandra.suitmediatest.data.model.Event

object DataDummy {
    fun listImage() =
        listOf(
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5
        )

    fun generateDummyEvent(): List<Event> {
        val listEvent = ArrayList<Event>()

        listEvent.add(
            Event(
                "Supertalk with Superstar Education : Information Technology vs Computer Science",
                "Jumat, 28 Mei 2021",
                "https://eventbandung.id/wp-content/uploads/2021/05/MP-EB-Supertalk-with-Superstar-Information-Technology-Vs-Computer-Science-%E2%80%93-Which-one-is-right-for-you-Superstar-Education-Jakarta-28-Mei-2021-Copy.jpg"
            )
        )

        listEvent.add(
            Event(
                "Campus Leaders Gathering : “Pandemi, Susah Cari Kerja?”",
                "Sabtu, 12 Juni 2021",
                "https://eventbandung.id/wp-content/uploads/2021/05/MP-EB-Webinar-Pandemi-Susah-Cari-Kerja-Campus-Network-12-Jun-2021-Copy.jpg"
            )
        )

        listEvent.add(
            Event(
                "Webinar #MYHealthChat “Pengaruh Covid-19 pada Anak Sekolah (Mental & Gizi)”",
                "Jumat, 28 Mei 2021",
                "https://eventbandung.id/wp-content/uploads/2021/05/MP-EB-Webinar-Kesehatan-MYHealtChat-Bdgcom_unity-28-Mei-2021-Copy.jpg"
            )
        )

        listEvent.add(
            Event(
                "Level Up Class “Wirausaha? Siapa Takut!”",
                "Jumat, 30 April 2021",
                "https://eventbandung.id/wp-content/uploads/2021/05/MP-EB-Wirausaha-Siapa-Takut-Level-Up-Class-30-Apr-2021-Copy.jpg"
            )
        )
        return listEvent
    }

}