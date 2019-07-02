var upload_image_url = "";
//接收上传文件的地址
var filefrom = "";
var returnFun = null;
var mulu = ""
var filename = "";
var filename1 = "";
var CONFIG_UPLOAD = "https://app.tjgaj.gov.cn/appsite/uploadbase64.aspx";

function m_img(m, fun) {
  mulu = m;
  returnFun = fun;
  uexWindow.cbActionSheet = function (opId, dataType, data) {
    if (data == 0) {
      paiopen();
    } else if (data == 1) {
      fileopen();
    }
  }
  var value = "拍照上传;本地上传";
  var mycars = value.split(";");
  uexWindow.actionSheet("", "取消", mycars);
}

function getFileName(o) {
  var pos = o.lastIndexOf("\\");
  return o.substring(pos + 1);
}

function paiopen() {
  //
  // uexCamera.cbOpen = function(opCode, dataType, data) {
  // filefrom = data;
  // upload();
  // }
  // uexCamera.open();

  uexCamera.open(0, 100, function (data) {
    filefrom = data;
    upload();
  });
}

function fileopen() {
  var cb = function (err, info) {
    if (err==0) {
      if (!/(iPhone|iPad|iPod|iOS)/i.test(navigator.userAgent)) {
        //安卓
        filefrom = info.data;
      } else {
        //IOS
        filefrom = "file://" + info.data;
      }
      upload();
    }
  }
  var pic = {
    min: 1,
    max: 1,
    quality: 1,
    detailedInfo: false
  }
  uexImage.openPicker(pic, cb);
}

function upload() {
  //以下接收地址修改为你服务器端的地址
  var uploadHttp = CONFIG_UPLOAD;

  randOpId = Math.floor(Math.random() * (1000 + 1));

  uexUploaderMgr.onStatus = function (opCode, fileSize, percent, serverPath, status) {
    switch (status) {
      case 0:
        uexWindow.toast("1", "5", percent + "%", "0");
        break;
      case 1:
        uexUploaderMgr.closeUploader(opCode);
        uexWindow.closeToast();
        uexWindow.toast("0", "5", "成功上传！", "2000");
        returnFun(serverPath.split('|')[1], serverPath.split('|')[0], filename1);
        break;
      case 2:
        uexWindow.closeToast();
        uexWindow.toast('0', '5', "上传失败", 2000);
        uexUploaderMgr.closeUploader(opCode);
        break;
      default:
        break;
    }
  }

  uexUploaderMgr.cbCreateUploader = function (opCode, dataType, data) {
    if (data == 0) {
      var path = filefrom;
      var inCompress = 2;
      var fname = randomString(16);
      filename = mulu + "\\" + fname;
      var result = /\.[^\.]+/.exec(upload_image_url);
      filename1 = fname + ".jpg";

      uexWindow.toast(1, 5, '上传中..', 0);
      if (uexWidgetOne.platformName == "iOS") {
        uexUploaderMgr.uploadFile(opCode, path, filename, inCompress, 300);
      }
      if (uexWidgetOne.platformName == "android") {
        uexUploaderMgr.uploadFile(opCode, path, filename, inCompress);
      }
    } else {
      uexWindow.closeToast();
      uexWindow.toast('0', '5', "创建上传失败", 3000);
    }
  }
  uexWindow.toast('1', '5', '正在上传...', '');
  uexUploaderMgr.createUploader(randOpId, uploadHttp);
}

function randomString(len) {
  len = len || 32;
  var $chars = 'ABCDEFGHJKMNPQRSTWXYZabcdefhijkmnprstwxyz2345678';
  /****默认去掉了容易混淆的字符oOLl,9gq,Vv,Uu,I1****/
  var maxPos = $chars.length;
  var pwd = '';
  for (i = 0; i < len; i++) {
    pwd += $chars.charAt(Math.floor(Math.random() * maxPos));
  }
  return pwd;
}

module.exports = m_img
