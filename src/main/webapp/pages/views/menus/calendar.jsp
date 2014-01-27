<head>
	
	<link rel="stylesheet" href="/timesheets/pages/css/bootstrap.calendar.css" type="text/css" />
    <script type="text/javascript" src="/timesheets/pages/js/bootstrap.calendar.js" ></script>
	
	<style>
      body {
        padding-top: 60px;
      }
    </style>
    
    <script type="text/javascript">
        $(document).ready(function(){

          var evnts = function(){
              return {"event":[]}
          };
          
          $('#calendar').Calendar({ 'events': evnts, 'weekStart': 1 }).on('changeDay', function(event){ 
				var date = event.month.valueOf() + '-' + event.day.valueOf() +'-'+ event.year.valueOf(); 
				$("#worklogForm").attr("action", "worklog?date=" + date);
				$('#calendar tr').find('td.selectedDay').removeClass('selectedDay');
				$('#day_'+event.day.valueOf()).addClass('selectedDay');
		  });
          
      });

    </script>
  </head>
    <div style="position:absolute;left:30px;">
      <div class="row">
        <div class="span4" id="calendar"></div>
      </div>
    </div> 
</body>
</html>
