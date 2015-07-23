<html ng-app>
<script type="text/javascript" src="js/library/angular.min.js"></script>
<script type="text/javascript" src="js/controller/AppsController.js"></script>

<body>
	<h2>Hello World!</h2>
	<link rel="stylesheet" type="text/css"
		href="plugins/player2/css/style.css">
	<link rel="stylesheet" type="text/css"
		href="plugins/player2/css/demo.css">
	<!-- <script type="text/javascript" src="plugins/player2/js/jquery-1.6.1.min.js"></script> -->
	<script type="text/javascript"
		src="plugins/player2/jquery-jplayer/jquery-1.6.1.min.js"></script>
	<script type="text/javascript"
		src="plugins/player2/jquery-jplayer/jquery.jplayer.js"></script>
	<script type="text/javascript"
		src="plugins/player2/ttw-music-player-min.js"></script>

	<script type="text/javascript">
		var myPlaylist = [

		{
			mp3 : 'rest/Gate/GetFile?command=content&subCommand=contentInfo&param={%22contentId%22:%22nojVa1Vg6vA%22}',

			title : 'Sample',
			artist : 'Sample',
			rating : 4,
			buy : '#',
			price : '0.99',
			duration : '0:30',
			cover : ''
		} ];

		$(document)
				.ready(
						function() {
							var description = 'sometext ';

							$('body').ttwMusicPlayer(myPlaylist, {
								autoPlay : false,
								description : description,
								jPlayer : {
									swfPath : 'plugins/player2/jquery-jplayer' //You need to override the default swf path any time the directory structure changes
								}
							});
						});
	</script>














	<link rel="stylesheet" type="text/css"
		href="plugins/media-player/css/jquery.jscrollpane.css" media="all" />
	<!-- scroll in playlist -->
	<link rel="stylesheet" type="text/css"
		href="plugins/media-player/css/jquery.selectbox.css" />
	<!-- playlist selector dropdown -->
	<link rel="stylesheet" type="text/css"
		href="plugins/media-player/css/html5audio_default.css" />
	<link rel="stylesheet" type="text/css"
		href="plugins/media-player/css/html5audio_basic.css" />

	<script type="text/javascript"
		src="plugins/media-player/js/swfobject.js"></script>
	<!-- flash backup -->
	<script type="text/javascript"
		src="plugins/media-player/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript"
		src="plugins/media-player/js/jquery-ui-1.10.3.custom.min.js"></script>
	<!-- jquery ui sortable/draggable -->
	<script type="text/javascript"
		src="plugins/media-player/js/jquery.ui.touch-punch.min.js"></script>
	<!-- mobile drag/sort -->
	<script type="text/javascript"
		src="plugins/media-player/js/jquery.XDomainRequest.js"></script>
	<!-- ofm ie9 and below fix -->
	<script type="text/javascript"
		src="plugins/media-player/js/jquery.mousewheel.min.js"></script>
	<!-- scroll in playlist -->
	<script type="text/javascript"
		src="plugins/media-player/js/jquery.jscrollpane.min.js"></script>
	<!-- scroll in playlist -->
	<script type="text/javascript"
		src="plugins/media-player/js/jquery.selectbox-0.2.js"></script>
	<!-- playlist selector dropdown -->
	<script type="text/javascript"
		src="plugins/media-player/js/id3-minimized.js"></script>
	<!-- id3 tags -->
	<script type="text/javascript"
		src="plugins/media-player/js/jquery.html5audio.min.js"></script>
	<script type="text/javascript"
		src="plugins/media-player/js/jquery.html5audio.func.js"></script>
	<script type="text/javascript"
		src="plugins/media-player/js/jquery.html5audio.settings_basic.js"></script>



	<select name="hap_playlist" id="hap_playlist" tabindex="1">
		<option value="playlist1">Local playlist 1</option>
	</select>




	<div id="componentWrapper">

		<div class="playerHolder">

			<div class="player_thumb">
				<img src='plugins/media-player/media/data/blank.png' alt='' />
			</div>

			<!-- progress -->
			<div class="player_progress">
				<div class="progress_bg"></div>
				<div class="load_progress"></div>
				<div class="play_progress"></div>
				<!-- progress tooltip -->
				<div class="player_progress_tooltip">
					<p></p>
				</div>
			</div>

			<div class="player_controls">
				<!-- pause/play -->
				<div class="controls_toggle">
					<img src='plugins/media-player/media/data/icons/set2/play.png' alt='controls_toggle' />
				</div>

				<!-- song name -->
				<div class="player_mediaName_Mask">
					<div class="player_mediaName"></div>
				</div>

				<!-- volume -->
				<div class="player_volume">
					<img src='plugins/media-player/media/data/icons/set2/volume.png' alt='player_volume' />
				</div>
				<div class="volume_seekbar">
					<div class="volume_bg"></div>
					<div class="volume_level"></div>
					<!-- volume tooltip -->
					<div class="player_volume_tooltip">
						<p></p>
					</div>
				</div>
			</div>

		</div>

		<div class="playlistHolder">
			<div class="componentPlaylist">
				<div class="playlist_inner">
					<!-- playlist items are appended here! -->
				</div>
			</div>
			<!-- preloader -->
			<div class="preloader"></div>
		</div>

	</div>















	<div id="playlist_list">

		<ul id='playlist1'>

			<li class='playlistItem' data-type='local'
				data-mp3='plugins/media-player/media/audio/1/Tim_McMorris_-_A_Bright_And_Hopeful_Future.mp3'
				data-ogg='plugins/media-player/media/audio/1/Tim_McMorris_-_A_Bright_And_Hopeful_Future.ogg'
				data-thumb='plugins/media-player/media/audio/1/Tim_McMorris_-_A_Bright_And_Hopeful_Future.jpg'
				data-download><a class='playlistNonSelected' href='#'><span
					class="hap_thumb"><img
						src="plugins/media-player/media/audio/1/Tim_McMorris_-_A_Bright_And_Hopeful_Future.jpg"
						alt="thumb" /></span><span class="hap_title"><p>Tim McMorris -
							A Bright And Hopeful Future</p></span></a></li>

			<li class='playlistItem' data-type='local'
				data-mp3='rest/Gate/GetFile?command=content&subCommand=contentInfo&param={%22contentId%22:%22nojVa1Vg6vA%22}'
				data-ogg='plugins/media-player/media/audio/1/Tim_McMorris_-_Be_My_Valentine.ogg'
				data-thumb='plugins/media-player/media/audio/1/Tim_McMorris_-_Be_My_Valentine.jpg'><a
				class='playlistNonSelected' href='#'><span class="hap_thumb"><img
						src="plugins/media-player/media/audio/1/Tim_McMorris_-_Be_My_Valentine.jpg"
						alt="thumb" /></span><span class="hap_title"><p>Tim McMorris -
							Be My Valentine</p></span></a></li>
		</ul>
	</div>





</body>
</html>
