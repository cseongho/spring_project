(function() {
		/* config */
		const config = {
			MAX_TITLE_LENGTH: 80,
			MAX_URL_LENGTH: 80,
			MAX_DESC_LENGTH: 140
		}


		/* util */
		function forceLengths(data) {
 			let { title, description, url } = data;

 			if (title.length > config.MAX_TITLE_LENGTH)
 				title = `${title.substring(0, config.MAX_TITLE_LENGTH)}...`
 			if (description.length > config.MAX_DESC_LENGTH)
 				description = `${description.substring(0, config.MAX_DESC_LENGTH)}...`
 			if (url.length > config.MAX_URL_LENGTH)
 				url = `${url.substring(0, config.MAX_URL_LENGTH)}...`

 			return {
 				title: title,
 				description: description,
 				url: url
 			}
		}

		function makePreviewNode (parent, data) {
			const { title, description, url } = data;

			let titleNode = document.createElement('span'),
				descNode = document.createElement('p'),
				urlNode = document.createElement('a');

			titleNode.classList.add("lp-preview-title");
			descNode.classList.add("lp-preview-desc");
			urlNode.classList.add("lp-preview-url");			

			titleNode.appendChild(document.createTextNode(title));
			descNode.appendChild(document.createTextNode(description));
			
			urlNode.setAttribute("href", url);
			urlNode.appendChild(document.createTextNode(url));

			parent.appendChild(titleNode);
			parent.appendChild(descNode);
			parent.appendChild(urlNode);

			return (parent);
		}

		var previews = document.querySelectorAll("div.lp-preview");
		if (previews.length === 0)
			return;

		previews.forEach((prev) => {
			let link = prev.querySelector('a');
			fetch(`https://cors-anywhere.herokuapp.com/${link.href}`, {
				method: 'GET',
				headers: {
					'access-control-allow-origin': '*'
				}
			})
			.then((res) => res.text())
			.then((html) => {
            	html = html.replace(/<\/?[A-Z]+[\w\W]*?>/g, function (m) {
                	return m.toLowerCase();
            	});

            	let dom = document.implementation.createHTMLDocument('');
            	dom.querySelector('html').innerHTML = html;
            	
            	let description = dom.querySelector("meta[name='description']") ||
            					  dom.querySelector("meta[property='og:description']") ||
            					  dom.querySelector("meta[property='description']");
            					  
            	if (description == null || description.length === 0)
            		description = dom.querySelector("p").innerText;

            	console.log(typeof description, description)

            	let ret = {
            		title : dom.querySelector('title').innerText,
            		url : link.href, // parent scope
            		description : '',
            		image : dom.querySelector('img'),
            	}

            	if (typeof description === "string")
            		ret.description = description;
            	else
            		ret.description = description.innerText || description.content || description.value

            	return ret;
			})
			.then((data) => {
				prev.innerText = '';
				data = forceLengths(data);
				makePreviewNode(prev, data);
			}).catch(err => console.log(err));
		})

})()