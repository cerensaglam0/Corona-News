package co.ceren.coronavirusapp.ui.main
//bir class tan bir class a veri aktarmak için bu interface oluşturuldu.
interface NewsAdapterCallback {
    fun onNewsItemClick(url:String?)   //adaptöründen activity ne ne aktaracaksan onu yaz


    //datayı gönderdiğin yerde parametre al
    //datayı göndereceğin yerde implement et

}