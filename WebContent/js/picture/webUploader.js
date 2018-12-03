var uploader;
$(function(){
	$list = $("#fileList");
	uploader = WebUploader.create({
	    // 选完文件后，是否自动上传。
	    auto: true,
	    // swf文件路径
	    swf: $("#ctx").val()+'/js/lib/webuploader/0.1.5/Uploader.swf',
	    // 文件接收服务端。
	    server: $("#ctx").val()+'/fileUpload/image.do',
	    // 选择文件的按钮。可选。
	    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
	    pick: '#filePicker',
	    // 只允许选择图片文件。
	    accept: {
	        title: 'Images',
	        extensions: 'gif,jpg,jpeg,bmp,png',
	        mimeTypes: 'image/*'
	    },
	    fileNumLimit:1
	});
	
	// 当有文件添加进来的时候
	uploader.on( 'fileQueued', function( file ) {
	    var $li = $(
	            '<div id="' + file.id + '" class="file-item thumbnail">' +
	                '<img>' +
	                '<div class="info">' + file.name + '</div>' +
	            '<input name="fileUrl" type="hidden" />'+
	            '<input name="fileName" type="hidden" value="'+file.name+'" /></div>'
	            ),
	    $img = $li.find('img');
	    // $list为容器jQuery实例
	    $list.append( $li );
	    // 创建缩略图
	    // 如果为非图片文件，可以不用调用此方法。
	    // thumbnailWidth x thumbnailHeight 为 100 x 100
	    uploader.makeThumb( file, function( error, src ) {
	        if ( error ) {
	            $img.replaceWith('<span>不能预览</span>');
	            return;
	        }
	        $img.attr( 'src', src );
	    }, 100, 100 );
	    
	    $("#deleteFile").show();
	    $("#filePicker").hide();
	    $("#deleteFile").on('click', function() {
	        uploader.removeFile( file );
	        $($li).remove();
	        $("#deleteFile").hide();
		    $("#filePicker").show();
		    $("input[name=fileName]").val("");
			$("input[name=fileUrl]").val("");
	    });
	});
	
	
	
	// 文件上传过程中创建进度条实时显示。
	uploader.on( 'uploadProgress', function( file, percentage ) {
	    var $li = $( '#'+file.id ),
	        $percent = $li.find('.progress span');

	    // 避免重复创建
	    if ( !$percent.length ) {
	        $percent = $('<p class="progress"><span></span></p>')
	                .appendTo( $li )
	                .find('span');
	    }

	    $percent.css( 'width', percentage * 100 + '%' );
	});

	// 文件上传成功，给item添加成功class, 用样式标记上传成功。
	uploader.on( 'uploadSuccess', function( file ) {
	    $( '#'+file.id ).addClass('upload-state-done');
	});

	// 文件上传失败，显示上传出错。
	uploader.on( 'uploadError', function( file ) {
	    var $li = $( '#'+file.id ),
	        $error = $li.find('div.error');

	    // 避免重复创建
	    if ( !$error.length ) {
	        $error = $('<div class="error"></div>').appendTo( $li );
	    }

	    $error.text('上传失败');
	});

	// 完成上传完了，成功或者失败，先删除进度条。
	uploader.on( 'uploadComplete', function( file ) {
	    $( '#'+file.id ).find('.progress').remove();
	});
	
	//上传服务端响应处理事件
	uploader.on( 'uploadAccept', function( object ,ret ) {
		$("input[name=fileUrl]").val(ret.fileUploadPath);
	});
	
});

	var getFileBlob = function (url, cb) {
		var xhr = new XMLHttpRequest();
		xhr.open("GET", url);
		xhr.responseType = "blob";
		xhr.addEventListener('load', function() {
			cb(xhr.response);
		});
		xhr.send();
	};

	var blobToFile = function (blob, name) {
		blob.lastModifiedDate = new Date();
		blob.name = name;
		return blob;
	};

	var getFileObject = function(filePathOrUrl,name, cb) {
		getFileBlob(filePathOrUrl, function (blob) {
			cb(blobToFile(blob, name));
		});
	};

function loadImg(name,src){
	//需要编辑的图片列表
	var picList1 = $("#fileUploadPath").val()+src;
	var picList = [picList1];
	$.each(picList, function(index,item){
		var $file = '<div><input name="fileUrl" type="hidden" value="'+src+'" />'+
		'<input name="fileName" type="hidden" value="'+src+'" /></div>';
		$list.append($file);
		$("#deleteFile").on('click', function() {
			$("#fileList").html("");
			$("#deleteFile").hide();
			$("#filePicker").show();
		});
		getFileObject(item,name, function (fileObject) {
			var wuFile = new WebUploader.Lib.File(WebUploader.guid('rt_'),fileObject);
			var file = new WebUploader.File(wuFile);
			uploader.addFiles(file);
		});
	});
    
    $("#deleteFile").show();
    $("#filePicker").hide();
    
}





