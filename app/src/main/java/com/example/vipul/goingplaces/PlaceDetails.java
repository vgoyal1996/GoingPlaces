package com.example.vipul.goingplaces;


import java.util.List;

public class PlaceDetails {


    /**
     * geometry : {"location":{"lat":28.633484,"lng":77.086747},"viewport":{"northeast":{"lat":28.63351915,"lng":77.0867832},"southwest":{"lat":28.63340175,"lng":77.0867316}}}
     * icon : https://maps.gstatic.com/mapfiles/place_api/icons/bank_dollar-71.png
     * id : d96a5ff583f575b8de3d2c45b5d500e39c13c302
     * name : Corporation Bank
     * opening_hours : {"open_now":false,"weekday_text":[]}
     * photos : [{"height":3120,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/112236855175733136841/photos\">Arvind Yadav<\/a>"],"photo_reference":"CoQBdwAAAPnCdECp5fDk5DlP-2rWB6F3YYukwgj0mJTLJV9B1PI7yMhAB1MKMHrJjZsjKB8tqMglPKlEOu-hsYDrhiF-GtDUzxyPyhhsY51RiX9ZBuLG_nn_PyxbJVx5ZFLWnQQJu5_3IbxJFUqOMGZ1Eu1ouopER56VLx_iawpoY6PJDs31EhBsty42eXXzz1RwZtEjhcOiGhQPuM-jBApV5577dmUD_S-zD8zrPQ","width":4208}]
     * place_id : ChIJIQ0y970EDTkR31kadCHzYFI
     * reference : CnRjAAAASIFD7oW5gz8RjPepHcnGZ-lvkqnP-_EC42pAqy83PhG-N87cwTYAl890bP1lTJNlUhyblOSwmCT678vPv_ZGsorugVssuI_71mi5N5GWosIyK6jYnsQ1IyK2B1ifj2YzRgHzMpQ3oxWGvHloTDeSAxIQQ9FYeaA9I9PkCvt49vOtORoUVzH40qo20ra2OMGts3tM254UdI4
     * scope : GOOGLE
     * types : ["bank","finance","point_of_interest","establishment"]
     * vicinity : W2-65, 1st Floor ,S-4/65A, Chatrapati Shivaji Marg, New Mahavir Nagar, Tilak Nagar, New Delhi
     */
    private static PlaceDetails obj = null;

    private List<ResultsBean> results;

    private PlaceDetails(List<ResultsBean> results){
        this.results = results;
    }

    public static PlaceDetails getInstance(){
        return obj;
    }

    public static boolean makeInstance(List<ResultsBean> r){
        if(obj==null){
            obj = new PlaceDetails(r);
            return true;
        }
        return false;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * location : {"lat":28.633484,"lng":77.086747}
         * viewport : {"northeast":{"lat":28.63351915,"lng":77.0867832},"southwest":{"lat":28.63340175,"lng":77.0867316}}
         */

        private GeometryBean geometry;
        private String icon;
        private String name;
        /**
         * open_now : false
         * weekday_text : []
         */

        private OpeningHoursBean opening_hours;
        private String vicinity;
        /**
         * height : 3120
         * html_attributions : ["<a href=\"https://maps.google.com/maps/contrib/112236855175733136841/photos\">Arvind Yadav<\/a>"]
         * photo_reference : CoQBdwAAAPnCdECp5fDk5DlP-2rWB6F3YYukwgj0mJTLJV9B1PI7yMhAB1MKMHrJjZsjKB8tqMglPKlEOu-hsYDrhiF-GtDUzxyPyhhsY51RiX9ZBuLG_nn_PyxbJVx5ZFLWnQQJu5_3IbxJFUqOMGZ1Eu1ouopER56VLx_iawpoY6PJDs31EhBsty42eXXzz1RwZtEjhcOiGhQPuM-jBApV5577dmUD_S-zD8zrPQ
         * width : 4208
         */

        private List<PhotosBean> photos;

        public GeometryBean getGeometry() {
            return geometry;
        }

        public void setGeometry(GeometryBean geometry) {
            this.geometry = geometry;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public OpeningHoursBean getOpening_hours() {
            return opening_hours;
        }

        public void setOpening_hours(OpeningHoursBean opening_hours) {
            this.opening_hours = opening_hours;
        }

        public String getVicinity() {
            return vicinity;
        }

        public void setVicinity(String vicinity) {
            this.vicinity = vicinity;
        }

        public List<PhotosBean> getPhotos() {
            return photos;
        }

        public void setPhotos(List<PhotosBean> photos) {
            this.photos = photos;
        }

        public static class GeometryBean {
            /**
             * lat : 28.633484
             * lng : 77.086747
             */

            private LocationBean location;

            public LocationBean getLocation() {
                return location;
            }

            public void setLocation(LocationBean location) {
                this.location = location;
            }

            public static class LocationBean {
                private double lat;
                private double lng;

                public double getLat() {
                    return lat;
                }

                public void setLat(double lat) {
                    this.lat = lat;
                }

                public double getLng() {
                    return lng;
                }

                public void setLng(double lng) {
                    this.lng = lng;
                }
            }
        }

        public static class OpeningHoursBean {
            private boolean open_now;
            private List<?> weekday_text;

            public boolean isOpen_now() {
                return open_now;
            }

            public void setOpen_now(boolean open_now) {
                this.open_now = open_now;
            }

            public List<?> getWeekday_text() {
                return weekday_text;
            }

            public void setWeekday_text(List<?> weekday_text) {
                this.weekday_text = weekday_text;
            }
        }

        public static class PhotosBean {
            private int height;
            private String photo_reference;
            private int width;
            private List<String> html_attributions;

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public String getPhoto_reference() {
                return photo_reference;
            }

            public void setPhoto_reference(String photo_reference) {
                this.photo_reference = photo_reference;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public List<String> getHtml_attributions() {
                return html_attributions;
            }

            public void setHtml_attributions(List<String> html_attributions) {
                this.html_attributions = html_attributions;
            }
        }
    }
}
