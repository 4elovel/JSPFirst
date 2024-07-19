<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Таймер зворотного відліку</title>
    <script>
      function startCountdown() {
        var countdownTime = document.getElementById("timeInput").value;
        var countdownDisplay = document.getElementById("countdownDisplay");

        var countdown = setInterval(function () {
          if (countdownTime <= 0) {
            clearInterval(countdown);
            countdownDisplay.innerHTML = "Час вийшов!";
          } else {
            countdownTime--;
            countdownDisplay.innerHTML = countdownTime + " секунд залишилось";
          }
        }, 1000);
      }
    </script>
</head>
<body>
<h1>Таймер зворотного відліку</h1>
<input type="number" id="timeInput" placeholder="Введіть час у секундах">
<button onclick="startCountdown()">Старт</button>
<p id="countdownDisplay"></p>
</body>
</html>
