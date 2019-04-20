const moviesApiUrl = "http://www.omdbapi.com?apikey=200eb0b9&t=";

const movie = new Vue({
         el: '#movie',
         data: {
        	 search: '',
             movie : null
         },
         methods :{
             searchMovies : function () {
                 this.$http.get(moviesApiUrl + this.search)
                     .then(function(response){
                         this.movie = response.data;
                     });
             },
         }
});
