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
                "https://eventbandung.id/wp-content/uploads/2021/05/MP-EB-Supertalk-with-Superstar-Information-Technology-Vs-Computer-Science-%E2%80%93-Which-one-is-right-for-you-Superstar-Education-Jakarta-28-Mei-2021-Copy.jpg",
                "Hello students! Ada ga sih dari kalian yang bingung mau ambil jurusan IT atau computer science? Pingin belajar coding tapi bingung harus masuk yang mana? Yuk temuin perbedaan jurusan IT dan computer science bersama Clarence, representative dari APU Malaysia.",
                "-7.061309422077791",
                "107.74833696749226"
            )
        )

        listEvent.add(
            Event(
                "Campus Leaders Gathering : “Pandemi, Susah Cari Kerja?”",
                "Sabtu, 12 Juni 2021",
                "https://eventbandung.id/wp-content/uploads/2021/05/MP-EB-Webinar-Pandemi-Susah-Cari-Kerja-Campus-Network-12-Jun-2021-Copy.jpg",
                "Haloo… Sobat Muda Indonesia Campus Leaders Gathering Zoominar Kembali Hadir. Berkolaborasi bersama beberapa Lembaga Anak Muda, yang semangat menghadirkan diskusi hangat dengan tema: PANDEMI, SUSAH CARI KERJA?",
                "-7.0603736643521415",
                "107.7500841321331"
            )
        )

        listEvent.add(
            Event(
                "Webinar #MYHealthChat “Pengaruh Covid-19 pada Anak Sekolah (Mental & Gizi)”",
                "Jumat, 28 Mei 2021",
                "https://eventbandung.id/wp-content/uploads/2021/05/MP-EB-Webinar-Kesehatan-MYHealtChat-Bdgcom_unity-28-Mei-2021-Copy.jpg",
                "Live dari Malaysia dan Indonesia, @aradamansara_medicalcentre @malaysiahealthcare @medtourismmy.id x @bdgcom_unity menghadirkan Webinar #MYHealthChat “Pengaruh Covid-19 pada Anak Sekolah (Mental & Gizi)”",
                "-7.0616338963983205",
                "107.74720068421578"
            )
        )

        listEvent.add(
            Event(
                "Level Up Class “Wirausaha? Siapa Takut!”",
                "Jumat, 30 April 2021",
                "https://eventbandung.id/wp-content/uploads/2021/05/MP-EB-Wirausaha-Siapa-Takut-Level-Up-Class-30-Apr-2021-Copy.jpg",
                "Hayo, siapa nih yang udah pengen jadi entrepreneur tapi masih ragu dan bingung mulai dari mana? Nah, kali ini Level Up bakal ajak kalian buat belajar bersama mengenai tantangan jadi entreprenur, bagaimana tips n trick menghadapinya, dan aspek apa saja yang harus diperhatikan. Catat tanggal dan waktunya ya!",
                "-7.060981264433127",
                "107.75036592605728"

            )
        )
        return listEvent
    }

}