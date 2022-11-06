package com.example.repositoryintern.ui.account

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.bumptech.glide.Glide
import com.example.repositoryintern.App
import com.example.repositoryintern.R
import com.example.repositoryintern.databinding.AccountFragmentBinding
import com.example.repositoryintern.ui.adapter.RecyclerViewAdapter
import com.example.repositoryintern.data.RecyclerViewItem
import javax.inject.Inject

class AccountFragment : Fragment() {

    private var bindingFragment: AccountFragmentBinding? = null
    private val binding
        get() = bindingFragment

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var adapterProfile: RecyclerViewAdapter
    private lateinit var adapterMoment: RecyclerViewAdapter
    private lateinit var adapterChronicles: RecyclerViewAdapter

    private val listProfile = listOf(
        RecyclerViewItem.ImageProfile("https://s3-alpha-sig.figma.com/img/eb06/17d4/9b16402c65a2df1f9d3933f3200dbfd9?Expires=1667779200&Signature=YfnbuI7UmAn6MDHeY~CP8rRehsf4A5bkTcurimmO4UlAOlc7carzJiIgju~iH31Tvm~uNqrjxOWSoFxwZugBIQMd4IGzplqeS-kcOlXJDnmWvL54QXDj4Kukl1BEF94kx0TwT35lrYPvg73FzHc6YiAyIcVIL7hR3XO2tFd84q~c3meiPhDsWFgNmX-uJpHvhFuIhzJ3ng9dquuSMhNVEvPQzmeH27AmgvsKKYKT0Qlk-TLgzMZP453trRXiQulzndYGKHMO0Y-ANARYufCuB62CZ8r1~tXDQH~8GzjeKVA9YP9l1sswyk-brdmZc8QYYMm~tbT2WO8taLZc6RhCNQ__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA"),
        RecyclerViewItem.ImageProfile("https://s3-alpha-sig.figma.com/img/f90a/a538/71e8004b0a6fc7118ffd40c49e2fe8a6?Expires=1667779200&Signature=d7ACW6LO4c881CnUHBLblrvMXHxtVmbSPTdHUmtb5Yc2-oMitOjePoj7t4y8I1Jv4dtt4QI2ciUuyaPD2RNLbNsDZ~1AOMsDrZE4~HpfglMlF1AYQPIIShY2-oOgjG~-NxPGswfeH8LKPK43POI8cKyTkWXzRVgVG0~SXIxia2k4un4YtEd4lhtiC-34t-Hs7UNP7wuCHvnWC7dZwbfgMI-Nz1XkiqoPlVkq7ikz77EDGGwFfDcZ2YKMSv6sRQEhZa8FS9NYtP-~ONj0IUiqo0cndYvDYZq20H3JgJcbj2zu7xi6fqxBUhqT-S9UGrZ97DPLZWYrzdVW0A4thpNa4w__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA"),
        RecyclerViewItem.ImageProfile("https://s3-alpha-sig.figma.com/img/b9ef/72ac/227fd80e5d40aecf904643447925319e?Expires=1667779200&Signature=SO6DEwIP0L3gyJci~Ld3dwuUFziDKHsWDD4psf4RL~5hB7Dgc0FHRMYZFZy29sDqq8BI1dZaaUdt~fnwmJGzLiy7KMO8EaTIiBt6OXwgEa9kJGlUWwvS1mM0OQ54zBBGVrCaAyELNAOWlAAKSvLVfdRAjEMHmjpdFyE8Cw4fhzGMmDE1aqLzGCImgUkk1vL8JKHh0rul0LW8ZG-V2MBb7IAz5t9ZzMbKRqmcT~~0PXjENvI6q9AuJjku5r~YdCTokocSBuhGdm0FKiywHou1QB5Lvh5OulNx1UgPjzFKgtisrhUUwwaVC8ct-rZt-wSjahLIyp8uOIPDukJhY7iu~w__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA"),
        RecyclerViewItem.ImageProfile("https://s3-alpha-sig.figma.com/img/4a31/e52c/6a94e2d07d0d083cbe05b9d09acbf228?Expires=1667779200&Signature=E9ZvxaxN0KLnLIpH5rpoE2azXzw76KR~8y7CrByKudud1JNRdN8LIGq3E3lagWH56w3NM7-Fyt1HMaw3KHqTCutFDQwZG1GTMMuhg1v8DhCspZt49o2H~2M6wB8aT~kSrO1Gazd8QOKkZ9h3QsGp05JHdkRap9YclfXZDkvI7804BDwEoWu5AUrKOxLhlVgcFSigSO~DyaimNxZMViDEEs~CIRL4mWa4N7iR0dUIgo7OFgteXVJ5eQ4y60Gj~6LDEdhBM2n2Aa-bMhUl7bT7xo8cuQ4kkeOE8OHeSRdNVxkirtm7zQc9AnFaiYeE~DAY1U-QE~YgdBGlZGlLXa9Vkg__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA")
    )

    private val listMoment = listOf(
        RecyclerViewItem.ImageMoment("https://s3-alpha-sig.figma.com/img/eb06/17d4/9b16402c65a2df1f9d3933f3200dbfd9?Expires=1667779200&Signature=YfnbuI7UmAn6MDHeY~CP8rRehsf4A5bkTcurimmO4UlAOlc7carzJiIgju~iH31Tvm~uNqrjxOWSoFxwZugBIQMd4IGzplqeS-kcOlXJDnmWvL54QXDj4Kukl1BEF94kx0TwT35lrYPvg73FzHc6YiAyIcVIL7hR3XO2tFd84q~c3meiPhDsWFgNmX-uJpHvhFuIhzJ3ng9dquuSMhNVEvPQzmeH27AmgvsKKYKT0Qlk-TLgzMZP453trRXiQulzndYGKHMO0Y-ANARYufCuB62CZ8r1~tXDQH~8GzjeKVA9YP9l1sswyk-brdmZc8QYYMm~tbT2WO8taLZc6RhCNQ__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA"),
        RecyclerViewItem.ImageMoment("https://s3-alpha-sig.figma.com/img/f90a/a538/71e8004b0a6fc7118ffd40c49e2fe8a6?Expires=1667779200&Signature=d7ACW6LO4c881CnUHBLblrvMXHxtVmbSPTdHUmtb5Yc2-oMitOjePoj7t4y8I1Jv4dtt4QI2ciUuyaPD2RNLbNsDZ~1AOMsDrZE4~HpfglMlF1AYQPIIShY2-oOgjG~-NxPGswfeH8LKPK43POI8cKyTkWXzRVgVG0~SXIxia2k4un4YtEd4lhtiC-34t-Hs7UNP7wuCHvnWC7dZwbfgMI-Nz1XkiqoPlVkq7ikz77EDGGwFfDcZ2YKMSv6sRQEhZa8FS9NYtP-~ONj0IUiqo0cndYvDYZq20H3JgJcbj2zu7xi6fqxBUhqT-S9UGrZ97DPLZWYrzdVW0A4thpNa4w__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA"),
        RecyclerViewItem.ImageMoment("https://s3-alpha-sig.figma.com/img/b9ef/72ac/227fd80e5d40aecf904643447925319e?Expires=1667779200&Signature=SO6DEwIP0L3gyJci~Ld3dwuUFziDKHsWDD4psf4RL~5hB7Dgc0FHRMYZFZy29sDqq8BI1dZaaUdt~fnwmJGzLiy7KMO8EaTIiBt6OXwgEa9kJGlUWwvS1mM0OQ54zBBGVrCaAyELNAOWlAAKSvLVfdRAjEMHmjpdFyE8Cw4fhzGMmDE1aqLzGCImgUkk1vL8JKHh0rul0LW8ZG-V2MBb7IAz5t9ZzMbKRqmcT~~0PXjENvI6q9AuJjku5r~YdCTokocSBuhGdm0FKiywHou1QB5Lvh5OulNx1UgPjzFKgtisrhUUwwaVC8ct-rZt-wSjahLIyp8uOIPDukJhY7iu~w__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA"),
        RecyclerViewItem.ImageMoment("https://s3-alpha-sig.figma.com/img/4a31/e52c/6a94e2d07d0d083cbe05b9d09acbf228?Expires=1667779200&Signature=E9ZvxaxN0KLnLIpH5rpoE2azXzw76KR~8y7CrByKudud1JNRdN8LIGq3E3lagWH56w3NM7-Fyt1HMaw3KHqTCutFDQwZG1GTMMuhg1v8DhCspZt49o2H~2M6wB8aT~kSrO1Gazd8QOKkZ9h3QsGp05JHdkRap9YclfXZDkvI7804BDwEoWu5AUrKOxLhlVgcFSigSO~DyaimNxZMViDEEs~CIRL4mWa4N7iR0dUIgo7OFgteXVJ5eQ4y60Gj~6LDEdhBM2n2Aa-bMhUl7bT7xo8cuQ4kkeOE8OHeSRdNVxkirtm7zQc9AnFaiYeE~DAY1U-QE~YgdBGlZGlLXa9Vkg__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA"),
        RecyclerViewItem.ImageMoment("https://s3-alpha-sig.figma.com/img/2d40/d0e6/f5450456996a50df945c251b8f198477?Expires=1667779200&Signature=X0YUGGLuUh2Fk4cMbCPArxwaVgBLTdvuOar6HKpcqBSYiMjiFOK-yqpDJWAFXLV5~Keqp33fyzOMhP~fqMfV0EUaQP8tiBoKMuF7s5bUbE7as~xFrICqYHyta6nFo4dkTmwhYKZUcHOjO43CuyzEB4z-U1uM0v2zVZuVRtVjcewtN5FU5t4JKG~-KgQrNjeCQiAPox0t~e65jfO20Tz48icIm98Wr9VzmfrAiXAoLDtJ-~Lu--1vBU4cHGDet1fWp31HuxrMYgJ9J6ci0cLPx85yhkvBD6HbKwxRxazC7l3rLN8Ez6QGehKapFwhbFaZk3Rr3WW4Od-IvPiILJPUpA__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA"),
        RecyclerViewItem.ImageMoment("https://s3-alpha-sig.figma.com/img/e5c7/25b9/ec204c89c7c2e3b4af2570c6377954e9?Expires=1667779200&Signature=b1wPEtGSSOSRBQY4-AYUNBLumZOjGQ3qBwxcg9eawlnA2cdmMFduHtqJmTseQk-AFebJO0fKSnLzssEaiHdg5tSVxebGV-14F6hsr60ijZv9~-cYsfje3qNsRdlQIN9ZsogJe6MA0BqGjZdEfldlNp21YrzCTz0MOFjrcEUE2m7DdAAoPJspoKlCOPPRw4Rqfe0jdoaF9KYzxmslGrs6nW-W1bz1AcJzQ2HkX6mbCxcku2q8rgV3bEfnDKBPNMTl9wtZ624Q58Ek2TyEnHDQno2FoZlORBuj5bpcUVod~1kCwMX8ClSelknlpAijlPcrTm634T74-1yp9zqsNsTsEA__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA")
    )

    private val listChronicles = listOf(
        RecyclerViewItem.ImageChronicles("https://s3-alpha-sig.figma.com/img/eb06/17d4/9b16402c65a2df1f9d3933f3200dbfd9?Expires=1667779200&Signature=YfnbuI7UmAn6MDHeY~CP8rRehsf4A5bkTcurimmO4UlAOlc7carzJiIgju~iH31Tvm~uNqrjxOWSoFxwZugBIQMd4IGzplqeS-kcOlXJDnmWvL54QXDj4Kukl1BEF94kx0TwT35lrYPvg73FzHc6YiAyIcVIL7hR3XO2tFd84q~c3meiPhDsWFgNmX-uJpHvhFuIhzJ3ng9dquuSMhNVEvPQzmeH27AmgvsKKYKT0Qlk-TLgzMZP453trRXiQulzndYGKHMO0Y-ANARYufCuB62CZ8r1~tXDQH~8GzjeKVA9YP9l1sswyk-brdmZc8QYYMm~tbT2WO8taLZc6RhCNQ__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA"),
        RecyclerViewItem.ImageChronicles("https://s3-alpha-sig.figma.com/img/f90a/a538/71e8004b0a6fc7118ffd40c49e2fe8a6?Expires=1667779200&Signature=d7ACW6LO4c881CnUHBLblrvMXHxtVmbSPTdHUmtb5Yc2-oMitOjePoj7t4y8I1Jv4dtt4QI2ciUuyaPD2RNLbNsDZ~1AOMsDrZE4~HpfglMlF1AYQPIIShY2-oOgjG~-NxPGswfeH8LKPK43POI8cKyTkWXzRVgVG0~SXIxia2k4un4YtEd4lhtiC-34t-Hs7UNP7wuCHvnWC7dZwbfgMI-Nz1XkiqoPlVkq7ikz77EDGGwFfDcZ2YKMSv6sRQEhZa8FS9NYtP-~ONj0IUiqo0cndYvDYZq20H3JgJcbj2zu7xi6fqxBUhqT-S9UGrZ97DPLZWYrzdVW0A4thpNa4w__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA"),
        RecyclerViewItem.ImageChronicles("https://s3-alpha-sig.figma.com/img/b9ef/72ac/227fd80e5d40aecf904643447925319e?Expires=1667779200&Signature=SO6DEwIP0L3gyJci~Ld3dwuUFziDKHsWDD4psf4RL~5hB7Dgc0FHRMYZFZy29sDqq8BI1dZaaUdt~fnwmJGzLiy7KMO8EaTIiBt6OXwgEa9kJGlUWwvS1mM0OQ54zBBGVrCaAyELNAOWlAAKSvLVfdRAjEMHmjpdFyE8Cw4fhzGMmDE1aqLzGCImgUkk1vL8JKHh0rul0LW8ZG-V2MBb7IAz5t9ZzMbKRqmcT~~0PXjENvI6q9AuJjku5r~YdCTokocSBuhGdm0FKiywHou1QB5Lvh5OulNx1UgPjzFKgtisrhUUwwaVC8ct-rZt-wSjahLIyp8uOIPDukJhY7iu~w__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA"),
        RecyclerViewItem.ImageChronicles("https://s3-alpha-sig.figma.com/img/2d40/d0e6/f5450456996a50df945c251b8f198477?Expires=1667779200&Signature=X0YUGGLuUh2Fk4cMbCPArxwaVgBLTdvuOar6HKpcqBSYiMjiFOK-yqpDJWAFXLV5~Keqp33fyzOMhP~fqMfV0EUaQP8tiBoKMuF7s5bUbE7as~xFrICqYHyta6nFo4dkTmwhYKZUcHOjO43CuyzEB4z-U1uM0v2zVZuVRtVjcewtN5FU5t4JKG~-KgQrNjeCQiAPox0t~e65jfO20Tz48icIm98Wr9VzmfrAiXAoLDtJ-~Lu--1vBU4cHGDet1fWp31HuxrMYgJ9J6ci0cLPx85yhkvBD6HbKwxRxazC7l3rLN8Ez6QGehKapFwhbFaZk3Rr3WW4Od-IvPiILJPUpA__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA"),
        RecyclerViewItem.ImageChronicles("https://s3-alpha-sig.figma.com/img/e5c7/25b9/ec204c89c7c2e3b4af2570c6377954e9?Expires=1667779200&Signature=b1wPEtGSSOSRBQY4-AYUNBLumZOjGQ3qBwxcg9eawlnA2cdmMFduHtqJmTseQk-AFebJO0fKSnLzssEaiHdg5tSVxebGV-14F6hsr60ijZv9~-cYsfje3qNsRdlQIN9ZsogJe6MA0BqGjZdEfldlNp21YrzCTz0MOFjrcEUE2m7DdAAoPJspoKlCOPPRw4Rqfe0jdoaF9KYzxmslGrs6nW-W1bz1AcJzQ2HkX6mbCxcku2q8rgV3bEfnDKBPNMTl9wtZ624Q58Ek2TyEnHDQno2FoZlORBuj5bpcUVod~1kCwMX8ClSelknlpAijlPcrTm634T74-1yp9zqsNsTsEA__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA"),
        RecyclerViewItem.ImageChronicles("https://s3-alpha-sig.figma.com/img/4a31/e52c/6a94e2d07d0d083cbe05b9d09acbf228?Expires=1667779200&Signature=E9ZvxaxN0KLnLIpH5rpoE2azXzw76KR~8y7CrByKudud1JNRdN8LIGq3E3lagWH56w3NM7-Fyt1HMaw3KHqTCutFDQwZG1GTMMuhg1v8DhCspZt49o2H~2M6wB8aT~kSrO1Gazd8QOKkZ9h3QsGp05JHdkRap9YclfXZDkvI7804BDwEoWu5AUrKOxLhlVgcFSigSO~DyaimNxZMViDEEs~CIRL4mWa4N7iR0dUIgo7OFgteXVJ5eQ4y60Gj~6LDEdhBM2n2Aa-bMhUl7bT7xo8cuQ4kkeOE8OHeSRdNVxkirtm7zQc9AnFaiYeE~DAY1U-QE~YgdBGlZGlLXa9Vkg__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA"),
        RecyclerViewItem.ImageChronicles("https://s3-alpha-sig.figma.com/img/e7a0/ac25/63c62266a71a20ef6f4f8cbb1faa81ca?Expires=1667779200&Signature=eIYc4ZEeboRMy~2MFeI8WGTRJw8s~ucan3tWu6RkRIxh8HL81o1dl7N-HgWdlrgmt3wkhEqq7EW0oSdZIXfvm6c4lazbnV0fYgYcMYuybab1bQBbJev5~WmBhqxKjU1GcR8a5vnZEwZepCRNnKBIV733bwxohz75aV7USN5-BKkRGNr~4UOVqi4Mvp6CvADNViYNEtsy2b~YVcyYlX-T-eB4P2XrWDNIcBPLTjN~WKoihmPs6leqITqszYIepSnQdvzPx~Q7CCbZ6iEGWoLMaGTJHbzQiRNv11Y9PLJX0cu2tvShxoesnrO-WyI3NCz0HbEJjN7VHSrco3DyofeTLw__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA"),
        RecyclerViewItem.ImageChronicles("https://s3-alpha-sig.figma.com/img/e7a0/ac25/63c62266a71a20ef6f4f8cbb1faa81ca?Expires=1667779200&Signature=eIYc4ZEeboRMy~2MFeI8WGTRJw8s~ucan3tWu6RkRIxh8HL81o1dl7N-HgWdlrgmt3wkhEqq7EW0oSdZIXfvm6c4lazbnV0fYgYcMYuybab1bQBbJev5~WmBhqxKjU1GcR8a5vnZEwZepCRNnKBIV733bwxohz75aV7USN5-BKkRGNr~4UOVqi4Mvp6CvADNViYNEtsy2b~YVcyYlX-T-eB4P2XrWDNIcBPLTjN~WKoihmPs6leqITqszYIepSnQdvzPx~Q7CCbZ6iEGWoLMaGTJHbzQiRNv11Y9PLJX0cu2tvShxoesnrO-WyI3NCz0HbEJjN7VHSrco3DyofeTLw__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA"),
        RecyclerViewItem.ImageChronicles("https://s3-alpha-sig.figma.com/img/4db0/9f38/a5ed4e09cda2807cff299604ff2df498?Expires=1667779200&Signature=eNS1VE32jSaF0epXpagG85hAyV-bLDUkRd~K3ZfdhliQq45HbFBKy9BYbNevDuEHihjpc8qRlrpnolj8g5BvzWwKQ8m9UyKAwru7XMgbqN-HkGLzvdi-SGbNFP1g256ZCdUStdbtfByxISNXYO8SyPfETtMNaWVjA6nzxRFDnMmyuISdyAlFLIo5TSBYk45xr8l70BnzD-cQDJIJVRLrbL8bhSoOBz7geIjInzW6HIjM1PU7Dpu4HcjpUQFlbOCbCIog-KzTGKkZESQHtM0lLmSwpSY6pmyiAFUOrXb64xHDHDBGufxPHBCiNiQB1mdYLi87jkB3s1a9sY6VU9qGfA__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA"),
        RecyclerViewItem.ImageChronicles("https://s3-alpha-sig.figma.com/img/90bc/fb41/c5f6d5365d40d5caba482c5de9b92930?Expires=1667779200&Signature=EjvyV8o38u1qNQUf4fA-mrI5eCrDnGpO5SLFZAsg3s~oH17IlSwa29kYIml9MuwlYqMvKe6Iimgtl8wjsgiqcP3ByCExOuSBEtGlHlPlZPrZInTU4Cbr1fX7xOv9XtllHV8e28p9hdFXaI0w3DyGDqVHIX8NDJVPM6z2TGWswTyVxIny4IereW7C1CBnXXv4lC22HMnLr3UjWDEvCACPRz9yTxi~uZ7a7zLlN7nKRVfZUB6fPBdAcO~AqgYOe~TDmmOX~CdnY53NpPmdzDW0aBFebxm9Z8VwKYBmGgguMtUyo~A7SzfGHiIzGmexmNjLEtnWGPTLWYo1q8TxvoiRgw__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA"),
        RecyclerViewItem.ImageChronicles("https://s3-alpha-sig.figma.com/img/4db0/9f38/a5ed4e09cda2807cff299604ff2df498?Expires=1667779200&Signature=eNS1VE32jSaF0epXpagG85hAyV-bLDUkRd~K3ZfdhliQq45HbFBKy9BYbNevDuEHihjpc8qRlrpnolj8g5BvzWwKQ8m9UyKAwru7XMgbqN-HkGLzvdi-SGbNFP1g256ZCdUStdbtfByxISNXYO8SyPfETtMNaWVjA6nzxRFDnMmyuISdyAlFLIo5TSBYk45xr8l70BnzD-cQDJIJVRLrbL8bhSoOBz7geIjInzW6HIjM1PU7Dpu4HcjpUQFlbOCbCIog-KzTGKkZESQHtM0lLmSwpSY6pmyiAFUOrXb64xHDHDBGufxPHBCiNiQB1mdYLi87jkB3s1a9sY6VU9qGfA__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA"),
        RecyclerViewItem.ImageChronicles("https://s3-alpha-sig.figma.com/img/90bc/fb41/c5f6d5365d40d5caba482c5de9b92930?Expires=1667779200&Signature=EjvyV8o38u1qNQUf4fA-mrI5eCrDnGpO5SLFZAsg3s~oH17IlSwa29kYIml9MuwlYqMvKe6Iimgtl8wjsgiqcP3ByCExOuSBEtGlHlPlZPrZInTU4Cbr1fX7xOv9XtllHV8e28p9hdFXaI0w3DyGDqVHIX8NDJVPM6z2TGWswTyVxIny4IereW7C1CBnXXv4lC22HMnLr3UjWDEvCACPRz9yTxi~uZ7a7zLlN7nKRVfZUB6fPBdAcO~AqgYOe~TDmmOX~CdnY53NpPmdzDW0aBFebxm9Z8VwKYBmGgguMtUyo~A7SzfGHiIzGmexmNjLEtnWGPTLWYo1q8TxvoiRgw__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA")
    )

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        bindingFragment = AccountFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        appBarConfiguration = AppBarConfiguration(navController.graph)
        binding?.apply {
            score.text = "4.3"
            nameAccFragment.text = getText(R.string.title_acc_name)
            titleLanguage.text = getText(R.string.title_language)
            titleLocation.text = getText(R.string.title_location)
            appBarAcFragment.setupWithNavController(navController, appBarConfiguration)
        }
        onClickBtn()
        adapterCreate()
    }

    private fun onClickBtn() {
        binding?.apply {
            btnPeople.setOnClickListener {
                navController.navigate(
                    AccountFragmentDirections.actionAccountFragmentToPeopleFragment()
                )
            }
        }
    }

    private fun adapterCreate() {
        adapterProfile = RecyclerViewAdapter()
        adapterMoment = RecyclerViewAdapter()
        adapterChronicles = RecyclerViewAdapter()
        binding?.apply {
            listImageProfile.adapter = adapterProfile
            listChronicles.adapter = adapterChronicles
            listMoments.adapter = adapterMoment
        }
        observe()
    }

    private fun observe() {
        adapterProfile.submitList(listProfile)
        adapterMoment.submitList(listMoment)
        adapterChronicles.submitList(listChronicles)
    }

    override fun onDestroy() {
        super.onDestroy()
        bindingFragment = null
    }
}