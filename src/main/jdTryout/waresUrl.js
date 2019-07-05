let minPrice = 0;
let filterText = [];

let tag = "ul";
let attr = "clstag";
let value = "secondtype|keycount|try|LBDP";
let aElements = document.getElementsByTagName(tag);
let aEle = [];
for (let i = 0; i < aElements.length; i++) {
    if (aElements[i].getAttribute(attr) === value) {
        aEle.push(aElements[i]);
    }
}
let parentNode1 = aEle[0];
const allChildNodes = function (node, type) {
    const allCN = [];
    const getAllChildNodes = function (node, type, allCN) {
        const nodes = node.childNodes;
        for (let i = 0; i < nodes.length; i++) {
            const child = nodes[i];
            if (child.className === "item applied" || child.nodeName === "#text") {
                continue;
            }

            if (child.className === "p-price ") {
                if (parseInt(child.childNodes[1].innerText.substr(1)) < minPrice) {
                    // alert("Price: " + parseInt(child.childNodes[1].innerText.substr(1)));
                    break;
                }
            }
            let flag = false;
            if (child.className === "p-name" && filterText.length > 0 && filterText[0]) {
                for (let j = 0; j < filterText.length; j++) {
                    if (child.innerText.indexOf(filterText[j]) >= 0) {
                        // alert("Filter: " + child.innerText);
                        flag = true;
                        break;
                    }
                }
            }
            if (flag) {
                break;
            }

            if (child.nodeName === type) {
                allCN.push(child.href);
            }
            getAllChildNodes(child, type, allCN);
        }
    };
    getAllChildNodes(node, type, allCN);
    return allCN;
};

chrome.storage.local.get("minPrice", (value1) => {
    minPrice = value1.minPrice;
    chrome.storage.local.get("filterText", (value2) => {
        filterText = value2.filterText;
        let allNode = allChildNodes(parentNode1, "A");
        // alert(allNode);
        chrome.storage.local.get({"waresUrl": []}, (value3) => {
            if (value3.waresUrl) {
                chrome.storage.local.set({"waresUrl": value3.waresUrl.concat(allNode)});
            } else {
                chrome.storage.local.set({"waresUrl": allNode});
            }
        });
    })
})

