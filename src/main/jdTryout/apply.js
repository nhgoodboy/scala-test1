let tag = "a";
let attr = "clstag";
let value = "secondtype|keycount|try|SQAN-1";
let value1 = "secondtype|keycount|try|TCAN-1";
let aElements = document.getElementsByTagName(tag);
let aEle = [];
for (let i = 0; i < aElements.length; i++) {
    if (aElements[i].getAttribute(attr) === value) {
        aEle.push(aElements[i]);
    }
}
if (aEle[0] !== undefined) {
    aEle[0].click();
    const timer = function () {
        const aElements = document.getElementsByTagName(tag);
        const aEle = [];
        for (let i = 0; i < aElements.length; i++) {
            if (aElements[i].getAttribute(attr) === value1) {
                aEle.push(aElements[i]);
            }
        }
        aEle[0].click();
    };
    setTimeout(timer, 2000);
}

