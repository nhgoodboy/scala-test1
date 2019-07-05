let tryUrl = [];
let parentNode = document.getElementById('J_topPage');
let pageNum = parseInt(parentNode.getElementsByTagName('i')[0].innerText);
chrome.storage.local.set({"pageNum": pageNum});
for (let i = 1; i < pageNum; i++) {
    tryUrl.push("https://try.jd.com/activity/getActivityList?page=" + i + "&activityState=0");
}
chrome.storage.local.set({"tryUrl": tryUrl});
