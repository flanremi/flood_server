var map = new AMap.Map('container', {
    viewMode: '2D',  // 默认使用 2D 模式
    zoom:14,  //初始化地图层级
    center: [120.709047,30.764811]  //初始化地图中心点
  });

    var temp = [120.709047,30.764811]
    //点位一（秀洲区政府）
    var circle1 = new AMap.Circle({
        center: temp,
        radius: 500, //半径
        borderWeight: 3,
        strokeColor: "#FF33FF", 
        strokeOpacity: 1,
        strokeWeight: 6,
        strokeOpacity: 0.2,
        fillOpacity: 0.4,
        strokeStyle: 'solid',
        strokeDasharray: [10, 10], 
        // 线样式还支持 'dashed'
        fillColor: '#FF0000',
        zIndex: 50,
    })

    //点位二（嘉兴市政府）
    var circle2 = new AMap.Circle({
        center: [120.755623,30.746814],
        radius: 500, //半径
        borderWeight: 3,
        strokeColor: "#FF33FF", 
        strokeOpacity: 1,
        strokeWeight: 6,
        strokeOpacity: 0.2,
        fillOpacity: 0.4,
        strokeStyle: 'solid',
        strokeDasharray: [10, 10], 
        // 线样式还支持 'dashed'
        fillColor: '#FF0000',
        zIndex: 50,
    })

    
    //点位三（乌镇）
    var circle3 = new AMap.Circle({
        center: [120.52171,30.73428],
        radius: 500, //半径
        borderWeight: 3,
        strokeColor: "#FF33FF", 
        strokeOpacity: 1,
        strokeWeight: 6,
        strokeOpacity: 0.2,
        fillOpacity: 0.4,
        strokeStyle: 'solid',
        strokeDasharray: [10, 10], 
        // 线样式还支持 'dashed'
        fillColor: '#FF0000',
        zIndex: 50,
    })
map.add(circle1);
map.add(circle2);
map.add(circle3);
// 缩放地图到合适的视野级别
map.setFitView([ circle1,circle2,circle3])
